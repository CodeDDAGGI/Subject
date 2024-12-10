package com.subject.subject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    private Long id;
    private Long movieId;
    private Long userId;
    private Double rating;
    private String content;
    private LocalDate created_at;
}
