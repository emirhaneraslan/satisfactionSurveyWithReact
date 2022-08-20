package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.services.IQuestionTypeServices;
import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import com.emirhaneraslan.data.repository.QuestionTypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2

public class QuestionTypeServiceImpl implements IQuestionTypeServices {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public QuestionTypeEntity createQuestionType(QuestionTypeEntity questionTypeEntity) {
        questionTypeRepository.save(questionTypeEntity);
        log.info("Başarıyla Eklendi");
        return questionTypeEntity;
    }

    @Override
    public List<QuestionTypeEntity> getAllQuestionType() {
        List<QuestionTypeEntity> list = new ArrayList<>();
        Iterable<QuestionTypeEntity> myList= questionTypeRepository.findAll();

        for (QuestionTypeEntity questionType: myList) {
            list.add(questionType);
        }

        return list;
    }

    @Override
    public ResponseEntity<QuestionTypeEntity> getQuestionTypeById(Long id) {
        QuestionTypeEntity questionTypeEntity=questionTypeRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(questionTypeEntity);
    }

    @Override
    public ResponseEntity<QuestionTypeEntity> updateQuestionType(Long id, QuestionTypeEntity questionTypeEntity) {
        QuestionTypeEntity questionType=questionTypeRepository.findById(id).orElseThrow();

        questionType.setQuestionType(questionTypeEntity.getQuestionType());

        QuestionTypeEntity questionType1=questionTypeRepository.save(questionType);
        return ResponseEntity.ok(questionType1);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteQuestionType(Long id) {
        QuestionTypeEntity questionTypeEntity= questionTypeRepository.findById(id).orElseThrow();
        questionTypeRepository.delete(questionTypeEntity);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
