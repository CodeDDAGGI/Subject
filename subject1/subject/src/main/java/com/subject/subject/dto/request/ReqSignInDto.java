package com.subject.subject.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class ReqSignInDto {
    private String email;
    private String password;
}
