package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.data.entity.SurveyEntity;
import com.emirhaneraslan.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ISurveyRest {

    SurveyEntity createSurvey(SurveyEntity surveyEntity);
    List<SurveyEntity> getAllSurvey();
    ResponseEntity<SurveyEntity> getSurveyById(Long id);
    ResponseEntity<SurveyEntity> updateSurvey(Long id,SurveyEntity surveyEntity);
    ResponseEntity<Map<String,Boolean>> deleteSurvey(Long id);

    List<SurveyEntity> findBySurveyIsActiveTrue();
    List<SurveyEntity> findBySurveyIsActiveFalse();


}
