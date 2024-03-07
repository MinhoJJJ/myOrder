package com.myOrder.controller;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    loginService loginService;

    @RequestMapping("/login/login.do")
    public HashMap<String, Object> login(memberDto memberDto,HttpServletRequest request) throws Exception {


        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        // 아이디 비밀번호 체크
        resultMap = loginService.findByUserInfo(memberDto);

        if(resultMap.get("result").equals("S")){
            HttpSession session = request.getSession(true);
            session.setAttribute("userName", resultMap.get("userName"));
        }
//        return new ResponseEntity<>(resultMap, HttpStatus.OK);
        return resultMap;
    }

    @RequestMapping("/login/signUp.do")
    public HashMap<String, Object> signUp(memberDto memberDto,HttpServletRequest request) throws Exception {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap=loginService.signUpMember(memberDto);
        return resultMap;
    }

    @RequestMapping("/main.do")
    public ModelAndView start(@RequestParam(value = "error", required = false) String error,
                @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {

            ModelAndView modelAndView;
            modelAndView = new ModelAndView("login/main");

            HttpSession session = request.getSession(true);

            modelAndView.addObject("error", error);
            modelAndView.addObject("exception", exception);
            return modelAndView;
    }
}