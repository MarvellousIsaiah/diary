package com.semicolon.africa.diary.controllers;

import com.semicolon.africa.diary.dto.LogInRequest;
import com.semicolon.africa.diary.dto.RegisterRequest;
import com.semicolon.africa.diary.exceptions.DiaryExceptions;
import com.semicolon.africa.diary.services.DiaryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class DiaryServicesController {
    @Autowired
    DiaryServicesImpl diaryServices;


    @PostMapping("/sign-up")
    public ResponseEntity<?> signUserUp(@RequestBody RegisterRequest request) {
        try {
            return new ResponseEntity<>(diaryServices.signUp(request), CREATED);
        } catch (DiaryExceptions e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }

    }


    @PostMapping("/log-out")
    public String logUserIn(@RequestBody String userName) {
        try {
            diaryServices.logOut(userName);
            return "successfully logged in";
        } catch (DiaryExceptions e){
        return e.getMessage();


        }
    }
}




