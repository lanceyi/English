package com.lance.model;

import java.util.ArrayList;
import java.util.List;

public class English_List {
  List<English> englishList = new ArrayList<English>();

    public List<English> getEnglishList () {
        return englishList;
    }

    public void setEnglishList (List<English> englishList) {
        this.englishList = englishList;
    }
}
