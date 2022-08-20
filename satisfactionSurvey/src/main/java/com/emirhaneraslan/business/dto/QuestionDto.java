package com.emirhaneraslan.business.dto;

import com.emirhaneraslan.data.entity.SurveyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private String question;
    private Long surveyId;
    private Long questionTypeId;
}
