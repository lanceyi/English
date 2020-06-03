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
     * @param sum 决定获取几个
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRand(int sum);

    /**
     * 获取所有题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAllTopicType();

    /**
     * 根据题型 获取随机答案
     * @param sum 决定获取几个
     * @param topicType 题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRandAnswerInTopicType(int sum, String topicType);

    /**
     * 获取题目 根据题型
     * @param id ID
     * @param topicType 题型
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicType(Long id, String topicType);

    /**
     * 获取随机题目 根据题型
     * @param sum 决定查询几个
     * @param topicType 题型
     * @return
     */
    List<QuestionEntity> getRandInTopicType(int sum, String topicType);
}
