package com.lance.controller;

import com.lance.service.impl.QuestionsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author youth
 */
@Controller
@RequestMapping(value = "exam")
public class ExamController {
    @Resource
    private QuestionsServiceImpl questionsService;

    private static final String EXAM = "/exam/";
    private static final String INDEX = EXAM + "index";

    @GetMapping(value = "index")
    public String toIndex() {
        return INDEX;
    }
}
