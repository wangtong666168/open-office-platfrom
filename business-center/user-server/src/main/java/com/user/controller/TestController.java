package com.user.controller;

import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {


    @Autowired
    private IUserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public Object getUser() throws Exception{
        return userService.getUser();
    }
}
