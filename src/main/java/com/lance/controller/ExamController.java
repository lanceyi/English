package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.QuestionsService;
import com.lance.service.impl.QuestionsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author youth
 */
@Controller
@RequestMapping(value = "/exam")
public class ExamController {
    @Resource
    private QuestionsService questionsService;

    private static final String EXAM = "exam/";
    private static final String INDEX = EXAM + "index";

    @GetMapping(value = "index")
    public ModelAndView index(
            @RequestParam(value = "id", defaultValue = "1")long id,
            @RequestParam(value = "rand", defaultValue = "false")boolean rand,
            @RequestParam(value = "topicType", defaultValue = "")String topicType,
            @RequestParam(value = "chapter", defaultValue = "")String chapter
    ) {
        ModelAndView modelAndView = new ModelAndView(INDEX);

        List<QuestionEntity> questions = questionsService.getQuestion(id, 1, rand, topicType, chapter);
        List<String> topicTypeList = questionsService.getAllTopicTypeToStringList();
        List<String> chapterList = questionsService.getAllChapterToStringList();
        // 获取选项
        int num = 3;
        List<String> answerList = new LinkedList<>();
        if (questions != null) {
            answerList = questionsService.getRandAnswerInTopicTypeDeduplicationToStringList(num, questions.get(0));
        } else {
            for (int i = 0; i < num; i++) {
                answerList.add("");
            }
        }
        // FIXME: 2020/7/11 偶尔还是会出现500
        // 提交信息
        Map<String, String> info = new LinkedHashMap<>();
        info.put("rand", String.valueOf(rand));
        info.put("topicType", topicType);
        info.put("chapter", chapter);


        // 题目与答案
        modelAndView.addObject("question", questions.get(0));
        // 题型
        modelAndView.addObject("topicTypeList", topicTypeList);
        // 章节
        modelAndView.addObject("chapterList", chapterList);
        // 随机选项
        modelAndView.addObject("answerList", answerList);
        // 提交信息
        modelAndView.addObject("info", info);
        return modelAndView;
    }
}
