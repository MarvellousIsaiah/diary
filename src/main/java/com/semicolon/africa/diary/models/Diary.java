package com.semicolon.africa.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("diaries")
public class Diary {
    private String userName;
    private String password;
    @Id
    private String id;
    @DBRef
    private List<Entry> entryList;
    private boolean isLocked;
}
