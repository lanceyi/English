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
@Service("QuestionsServiceImpl")
public class QuestionsServiceImpl implements QuestionsService {

    @Resource
    private QuestionDao questionDao;

    @Override
    public List<QuestionEntity> getAll() {
        return questionDao.getAll();
    }

    @Override
    public QuestionEntity getOne(long id) {
        return questionDao.getOne(id);
    }

    @Override
    public void insert (QuestionEntity question) {
        questionDao.insert(question);
    }


    @Override
    public void update (QuestionEntity question) {
        questionDao.update(question);
    }

    @Override
    public void delete (Long id) {
    questionDao.delete(id);
    }
}
