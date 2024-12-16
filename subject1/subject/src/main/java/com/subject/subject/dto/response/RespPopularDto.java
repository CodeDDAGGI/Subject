package com.subject.subject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespPopularDto {
    private Long id;
    private String title;
    private Double avgRating;
    private Long reviewCount;
}
