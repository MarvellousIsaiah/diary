package com.semicolon.africa.diary.dto;
import lombok.Data;

@Data
public class LogInResponse {
    private String userName;
    private final String message = "welcome to mavericks diary";
}
