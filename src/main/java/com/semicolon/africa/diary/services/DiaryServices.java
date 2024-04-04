package com.semicolon.africa.diary.services;

import com.semicolon.africa.diary.dto.*;
import com.semicolon.africa.diary.models.Entry;


import java.util.List;

public interface DiaryServices {
    RegisterResponse signUp(RegisterRequest request);
    LogInResponse logIn(LogInRequest logInRequest);
    EntryResponse createEntry(EntryRequest entryRequest);
    void logOut (String userName);
    List<Entry> viewEntry(String userName);

}
