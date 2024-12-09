package com.subject.subject.dto.response;

import com.subject.subject.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespSignUpDto {
    private String message;
    private User user;
}
