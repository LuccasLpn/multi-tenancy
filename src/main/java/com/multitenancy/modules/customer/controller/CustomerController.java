package com.multitenancy.modules.customer.controller;

import com.multitenancy.modules.customer.dto.CustomerPost;
import com.multitenancy.modules.customer.entity.Customer;
import com.multitenancy.modules.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/customer"})
public class CustomerController {

    public final CustomerService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<Customer> save(@RequestBody CustomerPost customerPost){
        Customer save = service.save(customerPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
