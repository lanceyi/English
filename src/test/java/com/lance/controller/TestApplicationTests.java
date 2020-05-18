package com.lance.controller;

import com.lance.model.English;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads () {

    }
    @Test
    void Save(){
        JsonController jsonController = new JsonController();
        try {
            jsonController.Save(new English(3,"xxx","xxx","xxx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void Read(){
        JsonController jsonController = new JsonController();
        try {
            jsonController.Read();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

