package com.lance.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class English {
    @JSONField(name = "Id")
    String id;
    @JSONField(name = "Topic")
    String topic;//题目
    @JSONField(name = "Answer")
    String answer;//答案
    @JSONField(name = "Prompt")
    String prompt;//提示

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

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

    @Override
    public String toString () {
        return JSONObject.toJSONString(this);
    }
}
