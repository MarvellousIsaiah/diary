package com.semicolon.africa.diary.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class EntryRequest {
    private String author;
    private String title;
    private String body;
    private LocalDateTime creationTime;
}
