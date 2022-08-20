package com.emirhaneraslan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", updatable = false, nullable = false)
    private Long answerId;

    @Column(name = "answer_str")
    private String answer;


    @ManyToOne
    @JoinColumn(name = "answer_question_id")
    private QuestionEntity question;


    @ManyToOne
    @JoinColumn(name = "answer_user_id")
    private UserEntity user;

    @Column(name = "answer_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate=new Date();
}
