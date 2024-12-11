package com.subject.subject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespRecommendDto {
    private Long movieId;
    private String title;
    private Double rating;
    private String releaseDate;
    private Long reviewCount;
}
