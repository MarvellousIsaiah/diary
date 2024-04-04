package com.semicolon.africa.diary.dto;

import com.semicolon.africa.diary.models.Diary;
import com.semicolon.africa.diary.models.Entry;

import java.time.LocalDateTime;

public class Mappers {
    public static EntryResponse mapEntryToResponse(Entry entry){
                    EntryResponse entryResponse = new EntryResponse();
                    entryResponse.setBody(entry.getBody());
                    entryResponse.setTitle(entry.getTitle());
                    entryResponse.setCreationTime(entry.getCreationTime());
                    return entryResponse;
    }


    public static void mapRequestToDiary(RegisterRequest registerRequest, Diary diary){
                         diary.setUserName(registerRequest.getUserName());
                         diary.setPassword(registerRequest.getPassword());
    }

    public  static RegisterResponse mapDiaryToResponse(Diary diary,RegisterResponse registerResponse){
                                 registerResponse.setUserName(diary.getUserName());
                                 return registerResponse;
    }

    public static void mapRequestToEntry(EntryRequest entryRequest, Entry entry){
                       entryRequest.setCreationTime(LocalDateTime.now());
                    entry.setCreationTime(entryRequest.getCreationTime());
                    entry.setBody(entryRequest.getBody());
                    entry.setTitle(entryRequest.getTitle());
                    entry.setAuthor(entryRequest.getAuthor());
    }


    public static LogInResponse mapLogInRequestToResponse(LogInRequest logInRequest){

                       LogInResponse logInResponse = new LogInResponse();
                       logInResponse.setUserName(logInRequest.getUserName());
                        return logInResponse;
    }


}
