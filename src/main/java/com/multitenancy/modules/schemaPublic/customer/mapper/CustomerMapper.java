package com.multitenancy.modules.schemaPublic.customer.mapper;

import com.multitenancy.modules.schemaPublic.customer.dto.CustomerPost;
import com.multitenancy.modules.schemaPublic.customer.dto.CustomerPut;
import com.multitenancy.modules.schemaPublic.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer toCustomer(CustomerPost customerPost);

    public abstract Customer toCustomer(CustomerPut customerPut);
}
