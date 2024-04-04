package com.semicolon.africa.diary.repository;

import com.semicolon.africa.diary.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntryRepository extends MongoRepository<Entry,String> {
      List<Entry> findEntryByAuthor(String Author);
      Entry findEntryByTitle(String title);

}
