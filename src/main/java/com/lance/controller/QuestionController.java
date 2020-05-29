package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.QuestionsService;
import com.lance.service.impl.QuestionsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author youth
 */
@Controller
@Log4j2
@RequestMapping(value = "/index")
public class QuestionController {

    @Resource
    private QuestionsServiceImpl questionsService;

    @GetMapping(value = "success")
    public String success(){
        log.info("test");
        return "success";
    }

    @GetMapping(value = "list")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<QuestionEntity> list = questionsService.getAll();
        log.info("list data:", list);
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
