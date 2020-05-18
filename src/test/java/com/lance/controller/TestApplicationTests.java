package com.lance.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads () {

    }
    @Test
    void Save(){
        JsonController jsonController = new JsonController();
        try {
            jsonController.Save();
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

