CREATE TABLE IF NOT EXISTS customer
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255),
    address         VARCHAR(255),
    cnpj            VARCHAR(255),
    is_active       BOOLEAN,
    insert_customer TIMESTAMP WITHOUT TIME ZONE,
    update_customer TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_cnpj UNIQUE (cnpj);


CREATE TABLE IF NOT EXISTS users
(
    id          BIGINT NOT NULL,
    password    VARCHAR(255),
    email       VARCHAR(255),
    name        VARCHAR(255),
    is_active   BOOLEAN,
    authorities VARCHAR(255),
    schema      VARCHAR(255),
    insert_user TIMESTAMP WITHOUT TIME ZONE,
    update_user TIMESTAMP WITHOUT TIME ZONE,
    customer_id BIGINT NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);