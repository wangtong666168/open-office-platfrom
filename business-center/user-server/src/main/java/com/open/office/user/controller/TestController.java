package com.open.office.user.controller;

import com.open.office.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {


    @Autowired
    private IUserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public Object getUser(@RequestParam String username) throws Exception{
        return userService.getUser(username);
    }
}
