package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.dto.QuestionDto;
import com.emirhaneraslan.business.services.IQuestionServices;
import com.emirhaneraslan.data.entity.QuestionEntity;
import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import com.emirhaneraslan.data.entity.SurveyEntity;
import com.emirhaneraslan.data.repository.QuestionRepository;
import com.emirhaneraslan.data.repository.QuestionTypeRepository;
import com.emirhaneraslan.data.repository.SurveyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class QuestionServiceImpl implements IQuestionServices {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    QuestionTypeRepository questionTypeRepository;


    @Override
    public QuestionEntity createQuestion(QuestionDto questionDto) {
        QuestionTypeEntity questionTypeEntity=this.questionTypeRepository.findById((questionDto.getQuestionTypeId())).orElseThrow();
        SurveyEntity surveyEntity=this.surveyRepository.findById((questionDto.getSurveyId())).orElseThrow();

        QuestionEntity questionEntity= new QuestionEntity();
        questionEntity.setQuestion(questionDto.getQuestion());
        questionEntity.setQuestionType(questionTypeEntity);
        questionEntity.setSurvey(surveyEntity);

        questionRepository.save(questionEntity);
        return questionEntity;
    }

    @Override
    public List<QuestionEntity> getAllQuestion() {
        List<QuestionEntity> list = new ArrayList<>();
        Iterable<QuestionEntity> myList=questionRepository.findAll();

        for (QuestionEntity questionEntity: myList) {
            list.add(questionEntity);
        }

        return list;
    }

    @Override
    public ResponseEntity<QuestionEntity> getQuestionById(Long id) {
        QuestionEntity questionEntity=questionRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(questionEntity);
    }

    @Override
    public List<QuestionEntity> findBySurvey_SurveyId(Long surveyId) {

        Iterable<QuestionEntity> myList= this.questionRepository.findBySurvey_SurveyId(surveyId);
        List<QuestionEntity> list= new ArrayList<>();

        for (QuestionEntity question : myList) {
            list.add(question);
        }

        return list;
    }




}

