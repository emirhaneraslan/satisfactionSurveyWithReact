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
@Table(name = "question_type")
public class QuestionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_type_id", updatable = false, nullable = false)
    private Long questionTypeId;

    @Column(name = "question_type")
    private String questionType;

    @JsonIgnore
    @OneToMany(mappedBy = "questionType")
    private List<QuestionEntity> questions;

    public QuestionTypeEntity(String questionType) {
        this.questionType = questionType;
    }
}
