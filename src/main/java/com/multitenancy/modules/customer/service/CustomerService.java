package com.multitenancy.modules.customer.service;

import com.multitenancy.modules.customer.dto.CustomerPost;
import com.multitenancy.modules.customer.entity.Customer;
import com.multitenancy.modules.customer.mapper.CustomerMapper;
import com.multitenancy.modules.customer.repository.CustomerRepository;
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
