package com.open.office.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @RequestMapping("add")
    @ResponseBody
    public int add(int a, int b){
        return  a+b;
    }


    @RequestMapping("bbb")
    public String bbb(){
        return "redirect:http://192.168.0.109:7000/document.html";
    }
}
