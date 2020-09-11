package com.neusoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
@RequestMapping( "/user")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello Controller ");
        return "success";
    }
    @RequestMapping(value = "/hello2",params = {"username"},headers = {"Accept"})
    public String sayHello1(){
        System.out.println("Hello Controller ");
        return "success";
    }
    @RequestMapping("/wangxijie")
    public String say(){
        System.out.println("wangxijie");
        return "success";
    }

}



