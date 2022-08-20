package com.emirhaneraslan.business.services;

import com.emirhaneraslan.data.entity.SurveyEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ISurveyServices {

    //CRUD
    //save
    public SurveyEntity createSurvey(SurveyEntity surveyEntity);

    //list
    public List<SurveyEntity> getAllSurvey();

    //find
    public ResponseEntity<SurveyEntity> getSurveyById(Long id);

    //update
    public ResponseEntity<SurveyEntity> updateSurvey(Long id,SurveyEntity surveyEntity);

    //delete
    public ResponseEntity<Map<String,Boolean>> deleteSurvey(Long id);

    List<SurveyEntity> findBySurveyIsActiveTrue();
    List<SurveyEntity> findBySurveyIsActiveFalse();


}
