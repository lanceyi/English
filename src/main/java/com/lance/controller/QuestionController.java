package com.lance.controller;

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

    @GetMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("control/index");
        List<QuestionEntity> list = questionsService.getAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping(value = "add")
    public String add() {
        return "control/add";
    }

    @PostMapping(value = "add")
    public ModelAndView postAdd() {
        ModelAndView modelAndView = new ModelAndView("control/index");
        return modelAndView;
    }

    @GetMapping(value = "update")
    public String update() {
        return "control/update";
    }


    @GetMapping(value = "delete")
    public String delect() {
        return "control/delete";
    }
}
