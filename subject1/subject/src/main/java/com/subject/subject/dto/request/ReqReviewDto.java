package com.subject.subject.dto.request;

import lombok.Data;

@Data
public class ReqReviewDto {
    private Long movieId;
    private Long userId;
    private Double rating;
    private String content;


}
