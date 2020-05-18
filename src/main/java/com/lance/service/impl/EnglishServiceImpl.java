package com.lance.service.impl;

import com.lance.dao.EnglishDao;
import com.lance.dao.impl.EnglishDaoImpl;
import com.lance.model.English;
import com.lance.service.EnglishService;

public class EnglishServiceImpl implements EnglishService {
    private EnglishDao englishDao;
    public EnglishServiceImpl(){
        englishDao = new EnglishDaoImpl();
    }
    @Override
    public int add (English english) {
       return englishDao.add(english);
    }
}
