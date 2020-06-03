package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.impl.QuestionsServiceImpl;
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
@RequestMapping(value = "exam")
public class ExamController {
    @Resource
    private QuestionsServiceImpl questionsService;

    private static final String EXAM = "/exam/";
    private static final String INDEX = EXAM + "index";

    @GetMapping(value = "index")
    public ModelAndView index(
            @RequestParam(value = "id", defaultValue = "1")long id,
            @RequestParam(value = "rand", defaultValue = "false")boolean rand,
            @RequestParam(value = "topicType", defaultValue = "")String topicType
    ) {
        ModelAndView modelAndView = new ModelAndView(INDEX);
        if (!rand) {
            QuestionEntity question;
            if (!"".equals(topicType))
            {
                question = questionsService.getOneInTopicType(id, topicType);
            } else {
                question = questionsService.getOne(id);
            }
            List<QuestionEntity> type = questionsService.getAllTopicType();
            List<QuestionEntity> answer = questionsService.getRandAnswerInTopicType(3, question.getTopicType());
            modelAndView.addObject("question", question);
            modelAndView.addObject("topicTypeList", type);
            modelAndView.addObject("answer", answer);
        } else {
            List<QuestionEntity> question;
            if (!"".equals(topicType))
            {
                question = questionsService.getRandInTopicType(1, topicType);
            } else {
                question = questionsService.getRand(1);
            }
            List<QuestionEntity> type = questionsService.getAllTopicType();
            List<QuestionEntity> answer = questionsService.getRandAnswerInTopicType(3, question.get(0).getTopicType());
            modelAndView.addObject("question", question);
            modelAndView.addObject("topicTypeList", type);
            modelAndView.addObject("answer", answer);
        }

        return modelAndView;
    }
}
