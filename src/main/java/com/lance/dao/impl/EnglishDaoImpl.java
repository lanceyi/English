package com.lance.dao.impl;

import com.lance.controller.JsonController;
import com.lance.dao.EnglishDao;
import com.lance.model.English;

public class EnglishDaoImpl implements EnglishDao {

    @Override
    public English findById (int id) {
        return null;
    }

    @Override
    public void Save (English english) {
    JsonController jsonController = new JsonController();
        try {
            jsonController.Save(english);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
