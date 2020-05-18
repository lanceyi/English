package com.lance.dao.impl;

import com.lance.util.JsonController;
import com.lance.dao.EnglishDao;
import com.lance.model.English;

public class EnglishDaoImpl implements EnglishDao {


    @Override
    public int add (English english) {
    JsonController jsonController = new JsonController();
        try {
            jsonController.Save(english);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
