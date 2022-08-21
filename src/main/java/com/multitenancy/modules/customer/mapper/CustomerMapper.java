package com.multitenancy.modules.customer.mapper;

import com.multitenancy.modules.customer.dto.CustomerPost;
import com.multitenancy.modules.customer.dto.CustomerPut;
import com.multitenancy.modules.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer toCustomer(CustomerPost customerPost);

    public abstract Customer toCustomer(CustomerPut customerPut);
}
