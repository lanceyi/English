package com.lance.entity;


import com.lance.dto.QuestionDto;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Aagmix
 */
@Data
@Entity
@Table(name = "Questions")
public class QuestionEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CHAPTER")
    private String chapter;
    @Column(name = "topicType")
    private String topicType;
    @Column(name = "TAG")
    private String tag;
    @Column(name ="TOPIC", nullable = false)
    private String topic;
    @Column(name = "ANSWER", nullable = false)
    private String answer;
    @Column(name = "PROMPT")
    private String prompt;

    public QuestionEntity(QuestionDto questionDto) {
        this.id = questionDto.getId();
        this.chapter = questionDto.getChapter();
        this.topicType = questionDto.getTopicType();
        this.tag = questionDto.getTag();
        this.topic = questionDto.getTopic();
        this.answer = questionDto.getAnswer();
        this.prompt = questionDto.getPrompt();
    }
}
