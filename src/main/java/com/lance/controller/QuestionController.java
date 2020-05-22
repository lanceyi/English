package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.mapper.QuestionMapper;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author youth
 */
@Controller
public class QuestionController {

    private QuestionMapper questionMapper;



    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        List<QuestionEntity> list = questionMapper.getAll();
        return "index";
    }
}
