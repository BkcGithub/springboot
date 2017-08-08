package com.bkc.springboot.controller;

import com.bkc.springboot.domain.BookBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private BookBean bookBean;
    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("helloworld")
    public String helloWorld() {
        logger.debug("访问HelloWorld");
        return "helloWorld " + bookBean.getAuthor() + ", " + bookBean.getName();
    }
}
