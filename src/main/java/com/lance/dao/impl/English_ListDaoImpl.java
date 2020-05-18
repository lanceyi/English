package com.lance.dao.impl;

import com.lance.util.JsonController;
import com.lance.dao.English_ListDao;
import com.lance.model.English;

import java.util.List;

public class English_ListDaoImpl implements English_ListDao {
    @Override
    public List<English> getAll () {
        JsonController jsonController=new JsonController();
        List<English> english_lists = null;
        try {
            english_lists = jsonController.Read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return english_lists;
    }
}
