package com.myOrder.controller;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.SessionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final loginService loginService;


    @PostMapping("/login3.do")
    public String login3(memberDto memberDto) {
        log.info("전달 받은 화면의 요청값 : {}", memberDto);
        return "main";
    }

    @RequestMapping("/login3.do")
    public String login3(memberDto memberDto, HttpServletRequest request) throws Exception {

        System.err.println("헬로우");
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        System.err.println(memberDto.getId());
        // 아이디 비밀번호 체크
        resultMap = loginService.findByUserInfo(memberDto);
        System.err.println( resultMap.get("result"));
        return "/main.do";

//        // 로그인 성공시 유저네임 세션부여
//        if(resultMap.get("result").equals("S")){
//            HttpSession session = request.getSession(true);
//            session.setAttribute("userName", resultMap.get("userName"));
//            return "/main.do";
//        }else{
//            throw new UsernameNotFoundException("조회된 회원이 없습니다");
//        }
    }
    @RequestMapping("/login.do")
    public UserDetails login(memberDto memberDto, HttpServletRequest request) throws Exception {

        System.err.println("헬로우");
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        System.err.println(memberDto.getId());
        // 아이디 비밀번호 체크
        resultMap = loginService.findByUserInfo(memberDto);
        System.err.println( resultMap.get("result"));
        // 로그인 성공시 유저네임 세션부여
        if(resultMap.get("result").equals("S")){
            HttpSession session = request.getSession(true);
            session.setAttribute("userName", resultMap.get("userName"));
            String[] auth = {"USER", "ADMIN"};
            return User.builder()
                    .username((String) resultMap.get("userName"))
                    .password(memberDto.getPassword())
                    .roles(auth)
                    .authorities(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN"))
                    .build();
        }else{
            throw new UsernameNotFoundException("조회된 회원이 없습니다");
        }
    }

    @RequestMapping("/signUp.do")
    public HashMap<String, Object> signUp(memberDto memberDto,HttpServletRequest request) throws Exception {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap=loginService.signUpMember(memberDto);
        return resultMap;
    }

    @RequestMapping("/main.do")
    public ModelAndView start(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
            System.err.println("/main.do");
            ModelAndView modelAndView;
            modelAndView = new ModelAndView("login/main");

            HttpSession session = request.getSession(true);

            modelAndView.addObject("error", error);
            modelAndView.addObject("exception", exception);
            return modelAndView;
    }
}