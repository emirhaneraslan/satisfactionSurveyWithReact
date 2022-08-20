package com.emirhaneraslan.business.services;

import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IQuestionTypeServices {

    //CRUD
    //save
    public QuestionTypeEntity createQuestionType(QuestionTypeEntity questionTypeEntity);

    //list
    public List<QuestionTypeEntity> getAllQuestionType();

    //find
    public ResponseEntity<QuestionTypeEntity> getQuestionTypeById(Long id);

    //update
    public ResponseEntity<QuestionTypeEntity> updateQuestionType(Long id,QuestionTypeEntity questionTypeEntity);

    //delete
    public ResponseEntity<Map<String,Boolean>> deleteQuestionType(Long id);
}
