package com.lance.controller;

import com.lance.entity.QuestionEntity;
import com.lance.service.QuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam(value = "rand", defaultValue = "false") boolean rand,
            @RequestParam(value = "topicType", defaultValue = "") String topicType,
            @RequestParam(value = "chapter", defaultValue = "") String chapter
    ) {
        final String PREVIOUS = "previous";
        final String QUESTION = "question";
        final String NEXT = "next";
        ModelAndView modelAndView = new ModelAndView(INDEX);

        Map<String, QuestionEntity> questions = questionsService.getQuestion(id, rand, topicType, chapter);
        QuestionEntity questionPrevious = questions.get(PREVIOUS);
        QuestionEntity question = questions.get(QUESTION);
        QuestionEntity questionNext = questions.get(NEXT);
        List<String> topicTypeList = questionsService.getAllTopicTypeToStringList();
        List<String> chapterList = questionsService.getAllChapterToStringList();
        // 获取选项
        int num = 3;
        List<String> answerList = new LinkedList<>();
        if (question != null) {
            answerList = questionsService.getRandAnswerInTopicTypeDeduplicationToStringList(num, question);
        } else {
            for (int i = 0; i < num; i++) {
                answerList.add("");
            }
        }
        // 提交信息
        Map<String, String> info = new LinkedHashMap<>();
        Map<String, Integer> infoId = new LinkedHashMap<>();
        info.put("rand", String.valueOf(rand));
        info.put("topicType", topicType);
        info.put("chapter", chapter);
        if (questionPrevious != null) {
            infoId.put("previousId", questionPrevious.getId());
        } else {
            infoId.put("previousId", -1);
        }
        if (questionNext != null) {
            infoId.put("nextId", questionNext.getId());
        } else {
            infoId.put("nextId", -1);
        }


        modelAndView.addObject("question", question);
        // 题型
        modelAndView.addObject("topicTypeList", topicTypeList);
        // 章节
        modelAndView.addObject("chapterList", chapterList);
        // 随机选项
        modelAndView.addObject("answerList", answerList);
        // 提交信息
        modelAndView.addObject("info", info);
        modelAndView.addObject("infoId", infoId);
        return modelAndView;
    }
}
