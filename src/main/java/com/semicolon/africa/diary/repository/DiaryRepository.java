package com.semicolon.africa.diary.repository;

import com.semicolon.africa.diary.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DiaryRepository extends MongoRepository<Diary,String> {
    Diary findDiariesByUserName(String userName);


}
