package com.semicolon.africa.diary.dto;
import lombok.Data;
@Data
public class RegisterResponse {
    private String userName;
    private final String message = "welcome onboard";
}
