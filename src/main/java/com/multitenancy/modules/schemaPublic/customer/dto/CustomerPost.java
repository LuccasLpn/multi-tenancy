package com.multitenancy.modules.schemaPublic.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class CustomerPost {

    private Long id;
    private String name;
    private String address;
    private String cnpj;
    private Boolean isActive;
    @JsonIgnore
    private Date insert;
    @JsonIgnore
    private Date update;
}
