package com.multitenancy.modules.schemaPublic.customer.service;

import com.multitenancy.modules.schemaPublic.customer.dto.CustomerPost;
import com.multitenancy.modules.schemaPublic.customer.entity.Customer;
import com.multitenancy.modules.schemaPublic.customer.mapper.CustomerMapper;
import com.multitenancy.modules.schemaPublic.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository repository;


    public Customer save(CustomerPost customerPost){
        Customer customer = CustomerMapper.INSTANCE.toCustomer(customerPost);
        customer.setInsert(new Date());
        customer.setUpdate(new Date());
        return repository.save(customer);
    }
}
