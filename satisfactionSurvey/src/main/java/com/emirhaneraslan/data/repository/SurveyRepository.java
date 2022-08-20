package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.SurveyEntity;
import com.emirhaneraslan.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity,Long> {

    List<SurveyEntity> findBySurveyIsActiveTrue();
    List<SurveyEntity> findBySurveyIsActiveFalse();

}
