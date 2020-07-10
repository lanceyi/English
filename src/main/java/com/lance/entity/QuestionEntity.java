package com.lance.entity;


import com.lance.dto.QuestionDto;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;

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

    public QuestionEntity() {
    }

    public QuestionEntity(QuestionDto questionDto) {
        this.id = questionDto.getId();
        this.chapter = questionDto.getChapter();
        this.topicType = questionDto.getTopicType();
        this.tag = questionDto.getTag();
        this.topic = questionDto.getTopic();
        this.answer = questionDto.getAnswer();
        this.prompt = questionDto.getPrompt();
    }

    public boolean isEmpty() {
        boolean result = true;
        if (this.id != null) {
            result = false;
        }
        if (this.chapter != null && !"".equals(this.chapter)) {
            result = false;
        }
        if (this.topicType != null && !"".equals(this.topicType)) {
            result = false;
        }
        if (this.tag != null && !"".equals(this.tag)) {
            result = false;
        }
        if (this.topic != null && !"".equals(this.topic)) {
            result = false;
        }
        if (this.answer != null && !"".equals(this.answer)) {
            result = false;
        }
        if (this.prompt != null && !"".equals(this.prompt)) {
            result = false;
        }
        return result;
    }
}
