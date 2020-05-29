package com.lance.controller;

import com.lance.entity.QuestionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author youth
 */
@Controller
public class IndexController {
    @RequestMapping
    public String index() {
        return "index";
    }
}
