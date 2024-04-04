package com.semicolon.africa.diary.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EntryResponse {
    private String title;
    private String body;
    private LocalDateTime creationTime;
}
