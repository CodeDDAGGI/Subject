package com.subject.subject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespSignInDto {
    private String expireDate;
    private String accessToken;
    private String token;
    private String message;
}
