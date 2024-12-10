package com.subject.subject.entity;

import com.subject.subject.security.prinsipalUser.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    public PrincipalUser toPrincipal() {
        return PrincipalUser.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
