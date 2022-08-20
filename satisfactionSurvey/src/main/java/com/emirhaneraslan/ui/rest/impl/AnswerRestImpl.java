package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.dto.AnswerDto;
import com.emirhaneraslan.business.services.IAnswerServices;
import com.emirhaneraslan.data.entity.AnswerEntity;
import com.emirhaneraslan.ui.rest.IAnswerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer/")
@CrossOrigin
public class AnswerRestImpl implements IAnswerRest {

    @Autowired
    IAnswerServices iAnswerServices;

    @Override
    @PostMapping("save")
    public AnswerEntity createAnswer(@RequestBody AnswerDto answerDto) {
        return this.iAnswerServices.createAnswer(answerDto);
    }

    @Override
    @GetMapping("findAll")
    public List<AnswerEntity> getAllAnswer() {
        return this.iAnswerServices.getAllAnswer();
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<AnswerEntity> getAnswerById(@PathVariable(name = "id") Long id) {
        return this.iAnswerServices.getAnswerById(id);
    }

    @Override
    @GetMapping("getbysurveyid/{id}")
    public List<AnswerEntity> findByQuestion_Survey_SurveyId(@PathVariable(name = "id") Long surveyId) {
        return this.iAnswerServices.findByQuestion_Survey_SurveyId(surveyId);
    }
}
