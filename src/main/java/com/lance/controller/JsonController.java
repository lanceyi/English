package com.lance.controller;

import com.alibaba.fastjson.JSON;
import com.lance.model.English;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
@Controller
public class JsonController {
    private List<English> listOfEnglish = new ArrayList<English>();
    @RequestMapping("/success")
    //存
    public void Save(){

    listOfEnglish.add(new English(1,"This is ____ apple","red","这是红苹果"));
    }
    //读
    public void Read(Model model){

    }
}

