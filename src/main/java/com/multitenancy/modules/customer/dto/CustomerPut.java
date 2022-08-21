package com.multitenancy.modules.customer.dto;

import lombok.*;

import java.util.Date;
@Data
@Builder
public class CustomerPut {
    private String name;
    private String address;
    private String cnpj;
    private Boolean isActive;
    private Date insert;
    private Date update;
}
