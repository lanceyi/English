package com.lance.dto;

public class English {
    String topic;//题目
    String answer;//答案
    String prompt;//提示

    public String getTopic () {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }

    public String getAnswer () {
        return answer;
    }

    public void setAnswer (String answer) {
        this.answer = answer;
    }

    public String getPrompt () {
        return prompt;
    }

    public void setPrompt (String prompt) {
        this.prompt = prompt;
    }
}
