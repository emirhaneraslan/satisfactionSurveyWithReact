package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.services.ISurveyServices;
import com.emirhaneraslan.data.entity.SurveyEntity;
import com.emirhaneraslan.ui.rest.ISurveyRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/survey/")
@CrossOrigin
public class SurveyRestImpl implements ISurveyRest {

    @Autowired
    ISurveyServices iSurveyServices;

    @Override
    @PostMapping("save")
    public SurveyEntity createSurvey(@RequestBody SurveyEntity surveyEntity) {
        iSurveyServices.createSurvey(surveyEntity);
        return surveyEntity;
    }

    @Override
    @GetMapping("findAll")
    public List<SurveyEntity> getAllSurvey() {
        List<SurveyEntity> myList=iSurveyServices.getAllSurvey();
        return myList;
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<SurveyEntity> getSurveyById(@PathVariable(name = "id") Long id) {
        ResponseEntity<SurveyEntity> findSurvey = iSurveyServices.getSurveyById(id);
        return findSurvey;
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<SurveyEntity> updateSurvey(@PathVariable(name = "id") Long id,@RequestBody SurveyEntity surveyEntity) {
        ResponseEntity<SurveyEntity> updateSurvey=iSurveyServices.updateSurvey(id,surveyEntity);
        return updateSurvey.ok(surveyEntity);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSurvey(@PathVariable(name = "id") Long id) {
        iSurveyServices.deleteSurvey(id);
        Map<String,Boolean> deleteSurvey= new HashMap<>();
        deleteSurvey.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(deleteSurvey);
    }

    @Override
    @GetMapping("activetrue")
    public List<SurveyEntity> findBySurveyIsActiveTrue() {
        return this.iSurveyServices.findBySurveyIsActiveTrue();
    }

    @Override
    @GetMapping("activefalse")
    public List<SurveyEntity> findBySurveyIsActiveFalse() {
        return this.iSurveyServices.findBySurveyIsActiveFalse();
    }


}
