package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.dto.AnswerDto;
import com.emirhaneraslan.business.services.IAnswerServices;
import com.emirhaneraslan.data.entity.AnswerEntity;
import com.emirhaneraslan.data.entity.QuestionEntity;
import com.emirhaneraslan.data.entity.UserEntity;
import com.emirhaneraslan.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerServices {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public AnswerEntity createAnswer(AnswerDto answerDto) {
        QuestionEntity questionEntity=this.questionRepository.findById(answerDto.getQuestionId()).orElseThrow();
        UserEntity userEntity=this.userRepository.findById(answerDto.getUserId()).orElseThrow();

        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setAnswer(answerDto.getAnswer());
        answerEntity.setQuestion(questionEntity);
        answerEntity.setUser(userEntity);

        answerRepository.save(answerEntity);
        return answerEntity;
    }

    @Override
    public List<AnswerEntity> getAllAnswer() {
        List<AnswerEntity> list = new ArrayList<>();
        Iterable<AnswerEntity> myList= answerRepository.findAll();

        for (AnswerEntity answerEntity: myList) {
            list.add(answerEntity);
        }
        return list;
    }

    @Override
    public ResponseEntity<AnswerEntity> getAnswerById(Long id) {
        AnswerEntity answerEntity= answerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(answerEntity);
    }

    @Override
    public List<AnswerEntity> findByQuestion_Survey_SurveyId(Long surveyId) {

        Iterable<AnswerEntity> myList = this.answerRepository.findByQuestion_Survey_SurveyId(surveyId);
        List<AnswerEntity> list = new ArrayList<>();

        for (AnswerEntity answer: myList) {
            list.add(answer);
        }
        return list;
    }
}
