package com.semicolon.africa.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("entries")
public class Entry {
    private String author;
    @Id
    private String id;
    private String title;
    private String body;
    private LocalDateTime creationTime;
}
