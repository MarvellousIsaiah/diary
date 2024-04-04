package com.semicolon.africa.diary.services;

import com.semicolon.africa.diary.dto.*;
import com.semicolon.africa.diary.exceptions.DiaryExceptions;
import com.semicolon.africa.diary.exceptions.DiaryNotFoundException;
import com.semicolon.africa.diary.exceptions.InvalidPasswordException;
import com.semicolon.africa.diary.models.Diary;
import com.semicolon.africa.diary.models.Entry;
import com.semicolon.africa.diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.semicolon.africa.diary.dto.Mappers.*;

@Service
public class DiaryServicesImpl implements DiaryServices{
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private EntryServicesImpl entryServices;
    @Override
    public RegisterResponse signUp(RegisterRequest request) {
        RegisterResponse registerResponse = new RegisterResponse();
        Diary diary = new Diary();
        mapRequestToDiary(request,diary);
        diaryRepository.save(diary);
       return mapDiaryToResponse(diary,registerResponse);
    }

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
        var diary = diaryRepository.findDiariesByUserName(logInRequest.getUserName());
             if(diary==null)throw new DiaryNotFoundException("you are not a valid user");
        if(diary.getPassword().equalsIgnoreCase(logInRequest.getPassword()))diary.setLocked(false);
              else throw new InvalidPasswordException("your details are not valid ");
              diaryRepository.save(diary);
        return mapLogInRequestToResponse(logInRequest);
    }

    @Override
    public EntryResponse createEntry(EntryRequest entryRequest) {
             Entry entry = new Entry();
             mapRequestToEntry(entryRequest,entry);
            entryServices.addEntryToRepo(entry);
            return mapEntryToResponse(entry);
    }

    @Override
    public void logOut(String userName) {
       Diary diary = diaryRepository.findDiariesByUserName(userName);
       if(diary.isLocked()) throw new DiaryExceptions("you are already logged out");
       diary.setLocked(true);
       diaryRepository.save(diary);
    }


    @Override
    public List<Entry> viewEntry(String userName) {
         return entryServices.findEntryByUserName(userName);

    }
}
