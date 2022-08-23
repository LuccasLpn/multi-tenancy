package com.multitenancy.modules.schemaPublic.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Data
@Builder
public class UserPost {

    @JsonIgnore
    private Long id;
    private String password;
    private String email;
    private String name;
    private Boolean isActive;
    private Long customerId;
    private String authorities;
    @JsonIgnore
    private String schema;
    @JsonIgnore
    private Date insert;
    @JsonIgnore
    private Date update;
}
