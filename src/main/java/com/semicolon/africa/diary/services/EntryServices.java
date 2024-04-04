package com.semicolon.africa.diary.services;

import com.semicolon.africa.diary.dto.EntryRequest;
import com.semicolon.africa.diary.dto.EntryResponse;
import com.semicolon.africa.diary.models.Entry;

import java.util.List;

public interface EntryServices {
    EntryResponse updateEntry(EntryRequest entryRequest);
    void addEntryToRepo(Entry entry);

    EntryResponse deleteEntryBy(String title);

    List<Entry> findEntryByUserName(String userName);
}
