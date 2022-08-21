package com.multitenancy.modules.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserPut {

    private String password;
    private String email;
    private String name;
    private Boolean isActive;
    private Long customerId;
    private String authorities;
    @JsonIgnore
    private String schema;
}
