package com.lance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author youth
 */
@Controller
public class QuestionController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
