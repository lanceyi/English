package com.lance.entity;


import lombok.Data;
/**
 * @author Aagmix
 */
@Data
public class QuestionEntity {
    private Integer id;
    private String chapter;
    private String topicType;
    private String tag;
    private String topic;
    private String answer;
    private String prompt;
}
