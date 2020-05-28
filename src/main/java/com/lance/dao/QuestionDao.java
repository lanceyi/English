package com.lance.dao;

import com.lance.entity.QuestionEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youth
 */
public interface QuestionDao {
    /**
     * 获取所有数据
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAll();

    /**
     * 根据ID获取一行数据
     * @param id
     * @return
     */
    QuestionEntity getOne(Long id);

    /**
     * 插入数据
     * @param question
     */
    void insert(QuestionEntity question);

    /**
     * 改
     * @param question
     */
    void update(QuestionEntity question);

    /**
     * 删
     * @param id
     */
    void delete(Long id);
}
