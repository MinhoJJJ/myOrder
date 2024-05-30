package com.myOrder.controller.Login;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignUpController {

    private final loginService loginService;

    @RequestMapping("/checkDuplicateIdAjax.do")
    public HashMap<String, Object> checkDuplicateIdAjax(memberDto memberDto, HttpServletRequest request) throws Exception {

        log.info("====================SignUpController.checkDuplicateIdAjax 아이디 중복체크 ====================");
        System.err.println("num1: "+memberDto.getId());

        // 아이디 비밀번호 체크
        return loginService.findByUserInfo(memberDto);
    }
//
//    @RequestMapping("/signUp22.do")
//    public HashMap<String, Object> signUp(memberDto memberDto,HttpServletRequest request) throws Exception {
//
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap=loginService.signUpMember(memberDto);
//        return resultMap;
//    }
//    @RequestMapping("/signUp.do")
//    public ModelAndView moveSignUp(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
//        log.info("====================loginController.moveSignUp 회원가입 이동 ====================");
//        ModelAndView modelAndView;
//        modelAndView = new ModelAndView("login/signUp");
//        HttpSession session = request.getSession(true);
//
//        modelAndView.addObject("error", error);
//        modelAndView.addObject("exception", exception);
//        return modelAndView;
//    }
//
//
//    @RequestMapping("/error.do")
//    public String loginError(Model model, HttpServletResponse response) {
//        log.info("====================loginController.start 메인화면 이동 ====================");
//        return "/dfdddd";
//    }
}