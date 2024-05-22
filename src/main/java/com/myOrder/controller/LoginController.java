package com.myOrder.controller;

import com.myOrder.dto.memberDto;
import com.myOrder.service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final loginService loginService;


    @RequestMapping("/login.do")
    public UserDetails login(memberDto memberDto, HttpServletRequest request) throws Exception {

        log.info("====================loginController.login 로그인 체크 ====================");
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // 아이디 비밀번호 체크
        resultMap = loginService.findByUserInfo(memberDto);
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


    @RequestMapping("/error.do")
    public String loginError(Model model, HttpServletResponse response) {
        log.info("====================loginController.start 메인화면 이동 ====================");
        return "/dfdddd";
    }
}