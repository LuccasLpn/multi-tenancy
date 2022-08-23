package com.multitenancy.modules.schemaPublic.multitenancy.connection;

import com.multitenancy.modules.schemaPublic.multitenancy.entity.TenantContext;
import org.flywaydb.core.Flyway;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

    private final DataSource dataSource;

    public MultiTenantConnectionProviderImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        final Connection connection = getAnyConnection();
        try {
            connection.createStatement().execute("create schema if not exists " + tenantIdentifier);
            String sql = "set schema " + "'" + tenantIdentifier + "'";
            if (!"public".equals(tenantIdentifier)){
                Flyway flyway = Flyway
                        .configure()
                        .locations("classpath:db/migration1")
                        .schemas(tenantIdentifier)
                        .dataSource("jdbc:postgresql://localhost:7076/multi_tenancy", "multi", "multi")
                        .cleanDisabled(false)
                        .load();
                flyway.migrate();
            }
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            throw new HibernateException("Não foi possivel alterar para o schema [" + tenantIdentifier + "]", e);
        }
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        try (connection) {
            String sql = "set schema " + "'" + TenantContext.DEFAULT_TENANT + "'";
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            throw new HibernateException("Não foi se conectar ao schema padrão", e);
        }
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

}
