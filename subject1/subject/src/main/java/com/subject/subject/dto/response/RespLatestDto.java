package com.subject.subject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RespLatestDto {
    private Long id;
    private String title;
    private LocalDate release_date;
}
