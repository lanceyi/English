package com.lance.controller;

import com.lance.dto.QuestionDto;
import com.lance.entity.QuestionEntity;
import com.lance.service.impl.QuestionsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author youth
 */
@Controller
@Log4j2
@RequestMapping(value = "/control")
public class QuestionController {

    @Resource
    private QuestionsServiceImpl questionsService;

    private static final String CONTROL = "control/";
    private static final String INDEX = CONTROL + "index";

    @GetMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(INDEX);
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "/control/add";
    }

    @GetMapping("/toUpdate")
    public ModelAndView toUpdate(Long id){
        ModelAndView modelAndView = new ModelAndView(CONTROL + "update");
        modelAndView.addObject("question", questionsService.getOne(id));
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(QuestionDto questionDto) {
        QuestionEntity question = new QuestionEntity(questionDto);
        questionsService.insert(question);
        ModelAndView modelAndView = new ModelAndView(INDEX);
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @PostMapping(value = "/update")
    public ModelAndView update(QuestionDto questionDto) {
        QuestionEntity question = new QuestionEntity(questionDto);
        questionsService.update(question);
        ModelAndView modelAndView = new ModelAndView(INDEX);
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @GetMapping(value = "/delete")
    public ModelAndView delete( Long id) {
        questionsService.delete(id);
        ModelAndView modelAndView = new ModelAndView(INDEX);
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
