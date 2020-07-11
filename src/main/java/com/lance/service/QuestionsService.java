package com.lance.service;

import com.lance.entity.QuestionEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author youth
 */
@Service("QuestionsService")
public interface QuestionsService {

    /**
     * 获取所有数据
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAll();

    /**
     * 获取单个数据
     * @param id ID
     * @return QuestionEntity
     */
    QuestionEntity getOne(int id);

    /**
     * 添加数据
     * @param question 添加的数据
     */
    void insert(QuestionEntity question);

    /**
     * 修改数据
     * @param question 修改的数据
     */
    void update(QuestionEntity question);

    /**
     * 删除数据
     * @param id ID
     */
    void delete(int id);

    /**
     * 根据题型 获取随机答案
     * @param num 决定获取几个
     * @param topicType 题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRandAnswerInTopicType(int num, String topicType);

    /**
     * 获取随机题目 根据题型
     * @param topicType 题型
     * @return QuestionEntity
     */
    QuestionEntity getRandInTopicType(String topicType);

    /**
     * 获取题目
     * @param id ID
     * @param rand 是否随机
     * @param topicType 题型
     * @param chapter 章节
     * @return QuestionEntity
     */
    Map<String, QuestionEntity> getQuestion(int id, boolean rand, String topicType, String chapter);


    /**
     * 获取所有题型并转换成 List<String>
     * @return List<String>
     */
    List<String> getAllTopicTypeToStringList();
    /**
     * 获取所有章节并转换成 List<String>
     * @return List<String>
     */
    List<String> getAllChapterToStringList();
    /**
     * 根据题型 获取随机答案后去重并转换成 List<String>
     * @return List<String>
     */
    List<String> getRandAnswerInTopicTypeDeduplicationToStringList(int num, QuestionEntity questionEntity);
}
