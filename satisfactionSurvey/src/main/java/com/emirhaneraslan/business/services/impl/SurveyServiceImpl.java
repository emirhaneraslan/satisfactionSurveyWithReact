package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.services.ISurveyServices;
import com.emirhaneraslan.data.entity.SurveyEntity;
import com.emirhaneraslan.data.entity.UserEntity;
import com.emirhaneraslan.data.repository.SurveyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2

public class SurveyServiceImpl implements ISurveyServices {


    @Autowired
    SurveyRepository surveyRepository;

    @Override
    public SurveyEntity createSurvey(SurveyEntity surveyEntity) {
        surveyRepository.save(surveyEntity);
        log.info("Ekleme başarılı");
        return surveyEntity;
    }

    @Override
    public List<SurveyEntity> getAllSurvey() {
        List<SurveyEntity> list = new ArrayList<>();
        Iterable<SurveyEntity> myList = surveyRepository.findAll();

        for (SurveyEntity survey: myList) {
            list.add(survey);
        }
        return list;
    }

    @Override
    public ResponseEntity<SurveyEntity> getSurveyById(Long id) {
        SurveyEntity surveyEntity=surveyRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(surveyEntity);
    }

    @Override
    public ResponseEntity<SurveyEntity> updateSurvey(Long id, SurveyEntity surveyEntity) {
        SurveyEntity survey=surveyRepository.findById(id).orElseThrow();

        survey.setSurveyName(surveyEntity.getSurveyName());
        survey.setCreatedDate(new Date());

        SurveyEntity surveyEntity1=surveyRepository.save(survey);

        return ResponseEntity.ok(surveyEntity1);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteSurvey(Long id) {
        SurveyEntity surveyEntity = surveyRepository.findById(id).orElseThrow();
        surveyRepository.delete(surveyEntity);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<SurveyEntity> findBySurveyIsActiveTrue() {
        Iterable<SurveyEntity> myList=this.surveyRepository.findBySurveyIsActiveTrue();
        List<SurveyEntity> list = new ArrayList<>();

        for (SurveyEntity survey: myList) {
            list.add(survey);
        }
        return list;
    }

    @Override
    public List<SurveyEntity> findBySurveyIsActiveFalse() {
        Iterable<SurveyEntity> myList=this.surveyRepository.findBySurveyIsActiveFalse();
        List<SurveyEntity> list = new ArrayList<>();

        for (SurveyEntity survey: myList) {
            list.add(survey);
        }
        return list;
    }



}
