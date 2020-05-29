package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.QuestionsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author youth
 */
@Controller
@Log4j2
@RequestMapping(value = "/index")
public class QuestionController {

    private QuestionsService questionsService;

    @GetMapping(value = "success")
    public String success(){
        log.info("test");
        return "success";
    }

    @GetMapping(value = "list")
    public ModelAndView index(@RequestParam(value = "id", defaultValue = "1")long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<QuestionEntity> list = questionsService.getAll();
        QuestionEntity one = questionsService.getOne(id);
        modelAndView.addObject("list", list);
        modelAndView.addObject("one", one);
        log.info("list data:", list);
        log.info("one data:", one);
        return modelAndView;
    }
}
