package com.multitenancy.modules.users.dto;
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
