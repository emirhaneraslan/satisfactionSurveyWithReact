package com.emirhaneraslan.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "survey")
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id", updatable = false, nullable = false)
    private Long surveyId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "survey_is_active")
    private boolean surveyIsActive=true;

    @JsonIgnore
    @OneToMany(mappedBy = "survey")
    private List<QuestionEntity> questions;

    @Column(name = "user_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate=new Date();

    public SurveyEntity(String surveyName) {
        this.surveyName = surveyName;
    }
}
