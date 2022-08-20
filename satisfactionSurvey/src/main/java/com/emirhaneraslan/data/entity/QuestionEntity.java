package com.emirhaneraslan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", updatable = false, nullable = false)
    private Long questionId;

    @Column(name = "question_str")
    private String question;


    @ManyToOne
    @JoinColumn(name = "question_survey_id")
    private SurveyEntity survey;



    @ManyToOne
    @JoinColumn(name = "question_question_type_id")
    private QuestionTypeEntity questionType;

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<AnswerEntity> answers;

    public QuestionEntity(String question, SurveyEntity survey, QuestionTypeEntity questionType) {
        this.question = question;
        this.survey = survey;
        this.questionType = questionType;
    }
}
