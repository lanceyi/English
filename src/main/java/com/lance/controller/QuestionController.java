package com.lance.controller;

import com.lance.dao.QuestionDao;
import com.lance.entity.QuestionEntity;
import com.lance.service.QuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author youth
 */
@Controller
public class QuestionController {

    private QuestionsService questionsService;

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "id", defaultValue = "1")long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<QuestionEntity> list = questionsService.getAll();
        QuestionEntity one = questionsService.getOne(id);
        modelAndView.addObject("list", list);
        modelAndView.addObject("one", one);
        System.out.println(list);
        System.out.println(one);
        return modelAndView;
    }
}
