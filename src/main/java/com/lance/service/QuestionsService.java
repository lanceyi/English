package com.lance.service;

import com.lance.entity.QuestionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("QuestionsService")
public interface QuestionsService {

    /**
     * 获取所有数据
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAll();

    /**
     * 获取单个数据
     * @param id
     * @return QuestionEntity
     */
    QuestionEntity getOne(long id);

    /**
     * 添加数据
     * @param
     * question
     */
    void insert(QuestionEntity question);

    /**
     * 修改数据
     * @param id
     */
    void update(QuestionEntity question);

    /**
     * 删除数据
     * @param id
     */
    void delete(Long id);
}
