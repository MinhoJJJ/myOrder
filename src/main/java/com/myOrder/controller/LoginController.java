package com.myOrder.controller;

import com.myOrder.dto.loginDto;
import com.myOrder.entity.Member;
import com.myOrder.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    loginService loginService;

    @GetMapping("/")
    public String login() {
        loginDto loginDto = new loginDto();
        loginDto.setUserId("wat");
        String name= loginService.findByUserName(loginDto);
        System.err.println(name);

        return "index";
    }
}