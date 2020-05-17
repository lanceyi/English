package com.lance.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class English {
    @JSONField(name = "Id")
    int id;
    @JSONField(name = "Topic")
    String topic;//题目
    @JSONField(name = "Answer")
    String answer;//答案
    @JSONField(name = "Prompt")
    String prompt;//提示


    public English(int id,String topic,String answer,String prompt){
        super();
        this.id = id;
        this.topic = topic;
        this.answer = answer;
        this.prompt = prompt;

    }
    @Override
    public String toString () {
        return JSONObject.toJSONString(this);
    }
}
