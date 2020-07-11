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
    QuestionEntity getOne(int id);

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
    void delete(int id);

    /**
     * 获取所有题型
     * @return list
     */
    List<QuestionEntity> getAllTopicType();

    /**
     * 获取所有章节
     * @return list
     */
    List<QuestionEntity> getAllChapter();


    /**
     * 获取答案
     * @param id ID
     * @return List<QuestionEntity>
     */
    QuestionEntity getOneAnswer(@Param("id") int id);

    /**
     * 获取答案 根据题型
     * @param id ID
     * @param topicType 题型
     * @return List<QuestionEntity>
     */
    QuestionEntity getOneAnswerInTopicType(@Param("id")int id, @Param("topicType")String topicType);

    /**
     * 获取题目 根据题型
     * @param id ID
     * @param topicType 题型
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicType(@Param("id")int id, @Param("topicType")String topicType);

    /**
     * 获取题目 根据章节
     * @param id ID
     * @param chapter 章节
     * @return QuestionEntity
     */
    QuestionEntity getOneInChapter(@Param("id")int id, @Param("chapter")String chapter);

    /**
     * 获取题目 根据 题型、章节
     * @param id ID
     * @param topicType 题型
     * @param chapter 章节
     * @return QuestionEntity
     */
    QuestionEntity getOneInTopicTypeChapter(@Param("id")int id, @Param("chapter")String chapter, @Param("topicType")String topicType);

    /**
     * 取最大ID
     * @return List<Integer>
     */
    List<Integer> getMinAndMaxId(@Param("chapter")String chapter, @Param("topicType")String topicType);
}
