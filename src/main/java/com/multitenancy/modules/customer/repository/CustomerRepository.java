package com.multitenancy.modules.customer.repository;

import com.multitenancy.modules.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
