package com.lance.dao;

import com.lance.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youth
 */
@Mapper
public interface QuestionDao {
    /**
     * 获取所有数据
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAll();

    /**
     * 根据ID获取一行数据
     * @param id ID
     * @return QuestionEntity
     */
    QuestionEntity getOne(Long id);

    /**
     * 插入数据
     * @param question 要插入的数据
     */
    void insert(QuestionEntity question);

    /**
     * 改
     * @param question 要修改的数据
     */
    void update(QuestionEntity question);

    /**
     * 删
     * @param id ID
     */
    void delete(Long id);

    /**
     * 获取所有题型
     * @return list
     */
    List<QuestionEntity> getAllTopicType();

    /**
     * 获取一个随机题目
     * @param num 决定查询几个
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRand(int num);

    /**
     * 获取随机答案
     * @param num 决定查询几个
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRandAnswer(int num);

    /**
     * 获取随机答案 根据题型
     * @param num 决定查询几个
     * @param topicType 题型
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getRandAnswerInTopicType(@Param("num")int num, @Param("topicType")String topicType);

    /**
     * 获取题目 根据题型
     * @param id ID
     * @param topicType 题型
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicType(@Param("id")Long id, @Param("topicType")String topicType);

    /**
     * 获取随机题目 根据题型
     * @param sum 决定查询几个
     * @param topicType 题型
     * @return
     */
    List<QuestionEntity> getRandInTopicType(@Param("num")int sum, @Param("topicType")String topicType);
}
