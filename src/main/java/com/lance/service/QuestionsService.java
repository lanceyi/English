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
}
