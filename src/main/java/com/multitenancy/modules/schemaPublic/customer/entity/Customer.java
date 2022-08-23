package com.multitenancy.modules.schemaPublic.customer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "insert_customer")
    private Date insert;

    @Column(name = "update_customer")
    private Date update;
}
