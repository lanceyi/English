package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.impl.QuestionsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.Id;
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

    @GetMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("control/index");
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/control/add";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Long id){
        ModelAndView modelAndView = new ModelAndView("/control/update");
        modelAndView.addObject("user", questionsService.getOne(id));
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(QuestionEntity question) {
        questionsService.insert(question);
        ModelAndView modelAndView = new ModelAndView("control/index");
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @PostMapping(value = "/update")
    public ModelAndView update(QuestionEntity question ) {
        questionsService.update(question);
        ModelAndView modelAndView = new ModelAndView("control/index");
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @GetMapping(value = "/delete")
    public ModelAndView delete( Long id) {
        questionsService.delete(id);
        ModelAndView modelAndView = new ModelAndView("control/index");
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
