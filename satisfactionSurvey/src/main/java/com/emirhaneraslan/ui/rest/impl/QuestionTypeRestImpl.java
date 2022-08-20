package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.services.IQuestionTypeServices;
import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import com.emirhaneraslan.ui.rest.IQuestionTypeRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questiontype/")
@CrossOrigin
public class QuestionTypeRestImpl implements IQuestionTypeRest {

    @Autowired
    IQuestionTypeServices iQuestionTypeServices;

    @Override
    @PostMapping("save")
    public QuestionTypeEntity createQuestionType(@RequestBody QuestionTypeEntity questionTypeEntity) {
        iQuestionTypeServices.createQuestionType(questionTypeEntity);
        return questionTypeEntity;
    }

    @Override
    @GetMapping("findAll")
    public List<QuestionTypeEntity> getAllQuestionType() {
        List<QuestionTypeEntity> myList= iQuestionTypeServices.getAllQuestionType();
        return myList;
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<QuestionTypeEntity> getQuestionTypeById(@PathVariable(name = "id") Long id) {
        ResponseEntity<QuestionTypeEntity> findQuestionType= iQuestionTypeServices.getQuestionTypeById(id);
        return findQuestionType;
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<QuestionTypeEntity> updateQuestionType(@PathVariable(name = "id") Long id, @RequestBody QuestionTypeEntity questionTypeEntity) {
        ResponseEntity<QuestionTypeEntity> updateQuestionType=iQuestionTypeServices.updateQuestionType(id, questionTypeEntity);
        return updateQuestionType.ok(questionTypeEntity);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteQuestionType(@PathVariable(name = "id") Long id) {
        iQuestionTypeServices.deleteQuestionType(id);
        Map<String,Boolean> deleteQuestionType=new HashMap<>();
        deleteQuestionType.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(deleteQuestionType);
    }
}
