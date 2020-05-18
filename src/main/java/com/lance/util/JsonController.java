package com.lance.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lance.model.English;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class JsonController {

    //存
    public void  Save (English  english) throws Exception {
       /* List<English> english_list =new ArrayList<English>();
        english_list.add(new English(1,"This is ____ apple","red","这是红苹果"));
        english_list.add(new English(2,"This is ____ apple","red","这是红苹果"));
        english_list.add(new English(3,"This is ____ apple","red","这是红苹果"));
        String jsonOutput= JSON.toJSONString(english_list);
        try {
            FileUtils.writeStringToFile(new File("src\\main\\resources\\english.json"),jsonOutput,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        List<English> english_list =new ArrayList<>();
        ObjectMapper  mapper =new ObjectMapper();
        english_list.add(english) ;
        String jsonOutput= JsonUtil.obj2String(english_list);
        mapper.writeValue(new File("src\\main\\resources\\english.json"),jsonOutput);

    }

    //读
    public List<English> Read() throws Exception {
        /*String jsonStr = null;
        //获取JSON文件内容，转化为字符串类型
        try {
             jsonStr = FileUtils.readFileToString(new File("src\\main\\resources\\english.json"), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;*/

        /*ObjectMapper mapper = new ObjectMapper();
        English english = mapper.readValue(new File("src\\main\\resources\\english.json"),English.class);
        System.out.println(english);*/

        ObjectMapper mapper = new ObjectMapper();
        String english = mapper.readValue(new File("src\\main\\resources\\english.json"),String.class);
        List<English> englishList = JsonUtil.string2Obj(english,List.class);
        return englishList;
    }
}

