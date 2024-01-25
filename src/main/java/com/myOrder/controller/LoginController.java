package com.myOrder.controller;

import com.myOrder.dto.memberDto;
import com.myOrder.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    loginService loginService;

    @GetMapping("/")
    public String login() {
        memberDto memberDto = new memberDto();
        memberDto.setUserId("wat");
        String name= loginService.findByUserName(memberDto);
        System.err.println(name);

        return "index";
    }
}