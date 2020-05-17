package com.lance.controller;

import com.lance.model.English;
import com.lance.model.English_List;

import java.util.List;

public class JsonController {
    English english;
    //存
    public void Save(){
      english = new English();
      english.setId("1");
      english.setTopic("the is ____ apple");
      english.setAnswer("red");
      english.setPrompt("这是红苹果");

    }
    //读
    public void Read(){

    }
}
