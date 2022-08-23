package com.multitenancy.modules.schemaPublic.customer.repository;

import com.multitenancy.modules.schemaPublic.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
