package com.lance.service;

import com.lance.entity.QuestionEntity;

import java.util.List;

public interface QuestionsService {

    /**
     * 获取所有数据
     * @return List<QuestionEntity>
     */
    List<QuestionEntity> getAll();
}
