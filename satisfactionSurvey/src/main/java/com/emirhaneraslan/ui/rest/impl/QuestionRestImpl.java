package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.dto.QuestionDto;
import com.emirhaneraslan.business.services.IQuestionServices;
import com.emirhaneraslan.data.entity.QuestionEntity;
import com.emirhaneraslan.ui.rest.IQuestionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question/")
@CrossOrigin
public class QuestionRestImpl implements IQuestionRest {

    @Autowired
    IQuestionServices iQuestionServices;

    @Override
    @PostMapping("save")
    public QuestionEntity createQuestion(@RequestBody QuestionDto questionDto) {
        return this.iQuestionServices.createQuestion(questionDto);
    }

    @Override
    @GetMapping("findAll")
    public List<QuestionEntity> getAllQuestion() {
        List<QuestionEntity> myList= iQuestionServices.getAllQuestion();
        return myList;
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<QuestionEntity> getQuestionById(@PathVariable(name = "id") Long id) {
        return this.iQuestionServices.getQuestionById(id);
    }

    @Override
    @GetMapping("getbysurveyid/{id}")
    public List<QuestionEntity> findBySurvey_SurveyId(@PathVariable(name = "id") Long surveyId) {
        return this.iQuestionServices.findBySurvey_SurveyId(surveyId);
    }


}
