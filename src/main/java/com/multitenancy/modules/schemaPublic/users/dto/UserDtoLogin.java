package com.multitenancy.modules.schemaPublic.users.dto;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserDtoLogin {
    private String email;
    private String password;
}
