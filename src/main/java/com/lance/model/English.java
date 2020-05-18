package com.lance.model;


import lombok.Data;
@Data
public class English {

    int id;
    String topic;//题目

    String answer;//答案

    String prompt;//提示
    public English(){

    }

    public English(int id,String topic,String answer,String prompt){
        super();
        this.id = id;
        this.topic = topic;
        this.answer = answer;
        this.prompt = prompt;

    }
}
