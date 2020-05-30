package com.lance.dto;

import lombok.Data;

/**
 * @author youth
 */
@Data
public class QuestionDto {
    private Integer id;
    private String chapter;
    private String topicType;
    private String tag;
    private String topic;
    private String answer;
    private String prompt;
}
