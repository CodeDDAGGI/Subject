package com.subject.subject.dto.request;

import com.subject.subject.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Builder
@Data
public class ReqSignUpDto {
    private String name;
    private String email;
    private String password;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
