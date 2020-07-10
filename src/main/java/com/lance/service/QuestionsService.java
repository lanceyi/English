package com.lance.service;

import com.lance.entity.QuestionEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

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
    QuestionEntity getOne(long id);

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
    void delete(Long id);

    /**
     * 获取题目 随机
     * @param num 决定获取几个
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRand(int num);

    /**
     * 获取所有题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAllTopicType();

    /**
     * 获取所有章节
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAllChapter();

    /**
     * 根据题型 获取随机答案
     * @param num 决定获取几个
     * @param topicType 题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRandAnswerInTopicType(int num, String topicType);

    /**
     * 获取题目 根据题型
     * @param id ID
     * @param topicType 题型
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicType(Long id, String topicType);

    /**
     * 获取题目 根据章节
     * @param id ID
     * @param chapter 章节
     * @return QuestionEntity
     */
    QuestionEntity getOneInChapter(Long id, String chapter);

    /**
     * 获取题目 根据题型、章节
     * @param id ID
     * @param topicType 题型
     * @param chapter 章节
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicTypeChapter(Long id, String topicType, String chapter);

    /**
     * 获取随机题目 根据题型
     * @param num 决定查询几个
     * @param topicType 题型
     * @return
     */
    List<QuestionEntity> getRandInTopicType(int num, String topicType);

    /**
     * 获取随机题目 根据章节
     * @param num 决定查询几个
     * @param chapter 章节
     * @return QuestionEntity
     */
    List<QuestionEntity> getRandInChapter(int num, String chapter);

    /**
     * 获取随机题目 根据题型、章节
     * @param num 决定查询几个
     * @param topicType 题型
     * @param chapter 章节
     * @return QuestionEntity
     */
    List<QuestionEntity> getRandInTopicTypeChapter(int num, String topicType, String chapter);

    /**
     * 获取题目
     * @param id ID
     * @param num 决定查询几个
     * @param rand 是否随机
     * @param topicType 题型
     * @param chapter 章节
     * @return QuestionEntity
     */
    List<QuestionEntity> getQuestion(Long id, int num, boolean rand, String topicType, String chapter);


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
