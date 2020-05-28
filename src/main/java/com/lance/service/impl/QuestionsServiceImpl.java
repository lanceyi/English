package com.lance.service.impl;

import com.lance.entity.QuestionEntity;
import com.lance.dao.QuestionDao;
import com.lance.service.QuestionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Aagmix
 */
@Service("QuestionsService")
public class QuestionsServiceImpl implements QuestionsService {

    private QuestionDao questionMapper;

    @Override
    public List<QuestionEntity> getAll() {
        return questionMapper.getAll();
    }

    @Override
    public QuestionEntity getOne(long id) {
        return questionMapper.getOne(id);
    }
}
