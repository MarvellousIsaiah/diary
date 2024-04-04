package com.semicolon.africa.diary.services;

import com.semicolon.africa.diary.dto.EntryRequest;
import com.semicolon.africa.diary.dto.EntryResponse;
import com.semicolon.africa.diary.models.Entry;
import com.semicolon.africa.diary.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.africa.diary.dto.Mappers.mapEntryToResponse;

@Service
public class EntryServicesImpl implements EntryServices{
    @Autowired
    EntryRepository entryRepository;

    @Override
    public EntryResponse updateEntry(EntryRequest entryRequest) {
                var entry = entryRepository.findEntryByTitle(entryRequest.getTitle());
                entry.setCreationTime(LocalDateTime.now());
                entry.setBody(entryRequest.getBody());
                entry.setTitle(entryRequest.getTitle());
                entryRepository.save(entry);
               return mapEntryToResponse(entry);
    }

    @Override
    public void addEntryToRepo(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public EntryResponse deleteEntryBy(String title) {
        var entry = entryRepository.findEntryByTitle(title);
        entryRepository.delete(entry);
        return mapEntryToResponse(entry);
    }

    @Override
    public List<Entry> findEntryByUserName(String userName) {
          return entryRepository.findEntryByAuthor(userName);
    }


}
