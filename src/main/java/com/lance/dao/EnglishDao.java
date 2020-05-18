package com.lance.dao;

import com.lance.model.English;

import java.util.ArrayList;

public interface EnglishDao {
    English findById(int id);

    void Save(English english);
}
