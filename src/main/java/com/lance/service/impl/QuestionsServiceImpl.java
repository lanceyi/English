package com.lance.service.impl;

import com.lance.entity.QuestionEntity;
import com.lance.dao.QuestionDao;
import com.lance.service.QuestionsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Aagmix
 */
@Service("QuestionsServiceImpl")
@Log4j2
public class QuestionsServiceImpl implements QuestionsService {

    @Resource
    private QuestionDao questionDao;

    @Override
    public List<QuestionEntity> getAll() {
        return questionDao.getAll();
    }

    @Override
    public QuestionEntity getOne(long id) {
        return questionDao.getOne(id);
    }

    @Override
    public void insert(QuestionEntity question) {
        questionDao.insert(question);
    }


    @Override
    public void update(QuestionEntity question) {
        questionDao.update(question);
    }

    @Override
    public void delete(Long id) {
        questionDao.delete(id);
    }

    @Override
    public List<QuestionEntity> getRand(int num) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                temp = questionDao.getOne(getRandId());
            }
            list.add(temp);
        }
        return list;
    }

    @Override
    public List<QuestionEntity> getAllTopicType() {
        return questionDao.getAllTopicType();
    }

    @Override
    public List<QuestionEntity> getAllChapter() {
        return questionDao.getAllChapter();
    }

    @Override
    public List<QuestionEntity> getRandAnswerInTopicType(int num, String topicType) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                long id = getRandId("", topicType);
                temp = questionDao.getOneAnswerInTopicType(id, topicType);
                while (temp == null) {
                    temp = questionDao.getOneAnswerInTopicType(id, topicType);
                }
            }
            int j = i - 1;
            QuestionEntity listdata = new QuestionEntity();
            if (!list.isEmpty()) {
                listdata = list.get(j);
            }
            if (!list.isEmpty() && temp.getAnswer().equals(listdata.getAnswer())) {
                temp.setAnswer("");
            }
            list.add(temp);
        }
        return list;
    }

    @Override
    public QuestionEntity getOneInTopicType(Long id, String topicType) {
        return questionDao.getOneInTopicType(id, topicType);
    }

    @Override
    public QuestionEntity getOneInChapter(Long id, String chapter) {
        return questionDao.getOneInTopicType(id, chapter);
    }

    @Override
    public QuestionEntity getOneInTopicTypeChapter(Long id, String topicType, String chapter) {
        return questionDao.getOneInTopicTypeChapter(id, topicType, chapter);
    }

    @Override
    public List<QuestionEntity> getRandInChapter(int num, String chapter) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                temp = questionDao.getOne(getRandId(chapter, ""));
            }
            list.add(temp);
        }
        return list;
    }

    @Override
    public List<QuestionEntity> getRandInTopicTypeChapter(int num, String topicType, String chapter) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                temp = questionDao.getOne(getRandId(chapter, topicType));
            }
            list.add(temp);
        }
        return list;
    }

    @Override
    public List<QuestionEntity> getRandInTopicType(int num, String topicType) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                temp = questionDao.getOne(getRandId("", topicType));
            }
            list.add(temp);
        }
        return list;
    }

    @Override
    public List<QuestionEntity> getQuestion(Long id, int num, boolean rand, String topicType, String chapter) {
        List<QuestionEntity> list = new LinkedList<>();
        if (rand) {
            if (num == 0) {
                return list;
            }
            if ("".equals(topicType) && "".equals(chapter)) {
                list = getRand(num);
            }
            // 题型有数据时
            else if (!"".equals(topicType) && "".equals(chapter)) {
                list = getRandInTopicType(num, topicType);
            }
            // 章节有数据时
            else if ("".equals(topicType)) {
                list = getRandInTopicType(num, topicType);
            }
            // 章节和题型有数据时
            else {
                list = getRandInTopicTypeChapter(num, topicType, chapter);
            }
        } else {
            if ("".equals(topicType) && "".equals(chapter)) {
                list.add(questionDao.getOne(id));
            }
            // 题型有数据时
            else if (!"".equals(topicType) && "".equals(chapter)) {
                list.add(questionDao.getOneInTopicType(id, topicType));
            }
            // 章节有数据时
            else if ("".equals(topicType)) {
                list.add(questionDao.getOneInChapter(id, chapter));
            }
            // 章节和题型有数据时
            else {
                list.add(questionDao.getOneInTopicTypeChapter(id, topicType, chapter));
            }
        }
        return list;
    }

    @Override
    public List<String> getAllTopicTypeToStringList() {
        return questionDao.getAllTopicType().stream().map(QuestionEntity::getTopicType).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllChapterToStringList() {
        return questionDao.getAllChapter().stream().map(QuestionEntity::getChapter).collect(Collectors.toList());
    }

    @Override
    public List<String> getRandAnswerInTopicTypeDeduplicationToStringList(int num, QuestionEntity questionEntity) {
        List<QuestionEntity> list = getRandAnswerInTopicType(num, questionEntity.getTopicType());
        for (QuestionEntity k : list) {
            // 判断是否有重复答案
            if (k.getAnswer().equals(questionEntity.getAnswer())) {
                getRandAnswerInTopicTypeDeduplicationToStringList(num, questionEntity);
            }
        }
        // 将list的 Answer 取出并转换成List<String>
        List<String> Slist = list.stream().map(QuestionEntity::getAnswer).collect(Collectors.toList());
        // 添加正确答案进去
        Slist.add(questionEntity.getAnswer());
        // 打乱
        Collections.shuffle(Slist);
        return Slist;
    }

    public long getRandId(String chapter, String topicType) {
        List<Integer> result = questionDao.getMinAndMaxId(chapter, topicType);
        int min = 0;
        int max = result.size() - 1;
        int randomNum = new Random().nextInt((max + 1 - min)) + min;
        return result.get(randomNum);
    }
    public long getRandId() {
        List<Integer> result = questionDao.getMinAndMaxId("", "");
        int min = 0;
        int max = result.size() - 1;
        int randomNum = new Random().nextInt((max + 1 - min)) + min;
        return result.get(randomNum);
    }
}
