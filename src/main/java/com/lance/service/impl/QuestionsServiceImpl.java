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
    public QuestionEntity getOne(int id) {
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
    public void delete(int id) {
        questionDao.delete(id);
    }

    public QuestionEntity getRand() {
        QuestionEntity temp = new QuestionEntity();
        while (temp.isEmpty()) {
            temp = questionDao.getOne(getRandId());
        }
        return temp;
    }

    @Override
    public List<QuestionEntity> getRandAnswerInTopicType(int num, String topicType) {
        List<QuestionEntity> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            QuestionEntity temp = new QuestionEntity();
            while (temp.isEmpty()) {
                int id = getRandId("", topicType);
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

    public QuestionEntity getRandInTopicTypeChapter(String topicType, String chapter) {
        QuestionEntity temp = new QuestionEntity();
        while (temp.isEmpty()) {
            temp = questionDao.getOne(getRandId(chapter, topicType));
        }
        return temp;
    }

    @Override
    public QuestionEntity getRandInTopicType(String topicType) {
        QuestionEntity temp = new QuestionEntity();
        while (temp.isEmpty()) {
            temp = questionDao.getOne(getRandId("", topicType));
        }
        return temp;
    }

    @Override
    public Map<String, QuestionEntity> getQuestion(int id, boolean rand, String topicType, String chapter) {
        Map<String, QuestionEntity> map;
        if (rand) {
            map = getQuestionRand(topicType, chapter);
        } else {
            map = getQuestionSequence(id, topicType, chapter);
        }
        return map;
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
        List<String> listS = list.stream().map(QuestionEntity::getAnswer).collect(Collectors.toList());
        // 添加正确答案进去
        listS.add(questionEntity.getAnswer());
        // 打乱
        Collections.shuffle(listS);
        return listS;
    }

    public int getRandId(String chapter, String topicType) {
        List<Integer> result = questionDao.getMinAndMaxId(chapter, topicType);
        int min = 0;
        int max = result.size() - 1;
        int randomNum = new Random().nextInt((max + 1 - min)) + min;
        return result.get(randomNum);
    }

    public int getRandId() {
        List<Integer> result = questionDao.getMinAndMaxId("", "");
        int min = 0;
        int max = result.size() - 1;
        int randomNum = new Random().nextInt((max + 1 - min)) + min;
        return result.get(randomNum);
    }

    public Map<String, QuestionEntity> mapQuestionPacker(QuestionEntity previous, QuestionEntity question, QuestionEntity next) {
        Map<String, QuestionEntity> map = new HashMap<>(3);
        map.put("previous", previous);
        map.put("question", question);
        map.put("next", next);
        return map;
    }

    public List<Integer> getIdList(String chapter, String topicType) {
        return questionDao.getMinAndMaxId(chapter, topicType);
    }

    public Map<String, QuestionEntity> getQuestionRand(String topicType, String chapter) {
        Map<String, QuestionEntity> map;
        QuestionEntity previous = new QuestionEntity();
        QuestionEntity questionEntity;
        QuestionEntity next = new QuestionEntity();
        if ("".equals(topicType) && "".equals(chapter)) {
            questionEntity = getRand();
        }
        // 题型有数据时
        else if (!"".equals(topicType) && "".equals(chapter)) {
            questionEntity = getRandInTopicType(topicType);
        }
        // 章节有数据时
        else if ("".equals(topicType)) {
            questionEntity = getRandInTopicType(topicType);
        }
        // 章节和题型有数据时
        else {
            questionEntity = getRandInTopicTypeChapter(topicType, chapter);
        }
        map = mapQuestionPacker(previous, questionEntity, next);
        return map;
    }

    public Map<String, QuestionEntity> getQuestionByIdList(int id, List<Integer> idList) {
        Map<String, QuestionEntity> map;
        QuestionEntity previous;
        QuestionEntity questionEntity;
        QuestionEntity next;

        int idi = idList.lastIndexOf(id);
        if (idi != -1) {
            previous = questionDao.getOne(id - 1);
            questionEntity = questionDao.getOne(id);
            next = questionDao.getOne(id + 1);
        } else {
            int tempId = idList.get(0);
            previous = questionDao.getOne(tempId - 1);
            questionEntity = questionDao.getOne(tempId);
            next = questionDao.getOne(tempId + 1);
        }
        map = mapQuestionPacker(previous, questionEntity, next);
        return map;
    }

    public Map<String, QuestionEntity> getQuestionSequence(int id, String topicType, String chapter) {
        Map<String, QuestionEntity> map;
        QuestionEntity previous;
        QuestionEntity questionEntity;
        QuestionEntity next;

        if ("".equals(topicType) && "".equals(chapter)) {
            previous = questionDao.getOne(id - 1);
            questionEntity = questionDao.getOne(id);
            next = questionDao.getOne(id + 1);
            map = mapQuestionPacker(previous, questionEntity, next);
        }
        // 题型有数据时
        else if (!"".equals(topicType) && "".equals(chapter)) {
            List<Integer> idList = getIdList("", topicType);
            map = getQuestionByIdList(id, idList);
        }
        // 章节有数据时
        else if ("".equals(topicType)) {
            List<Integer> idList = getIdList(chapter, "");
            map = getQuestionByIdList(id, idList);
        }
        // 章节和题型有数据时
        else {
            List<Integer> idList = getIdList(chapter, topicType);
            map = getQuestionByIdList(id, idList);
        }

        return map;
    }
}
