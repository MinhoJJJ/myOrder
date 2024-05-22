package com.myOrder.controller;


import com.myOrder.dto.memberDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/")
    public ModelAndView start(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception) {

        ModelAndView modelAndView;
        modelAndView = new ModelAndView("login/loginForm");

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @RequestMapping("/main.do")
    public ModelAndView moveMain(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        log.info("====================MainController.moveMain 메인화면 이동 ====================");
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/main");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @RequestMapping("/transaction.do")
    public ModelAndView moveTransation(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        log.info("====================MainController.moveTransation 거래추가 화면 이동 ====================");
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/transaction");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    @RequestMapping("/header.do")
    public ModelAndView moveHeader(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        log.info("====================MainController.moveHeader 헤더화면 추가 ====================");
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/header");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @RequestMapping("/report.do")
    public ModelAndView moveReport(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        log.info("====================MainController.moveReport 리포트 화면 이동 ====================");
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/report");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    // 레스트 컨트롤러 아닌 방식
//    @GetMapping("/")
//    public String main() {
//        return "/login/loginForm.html";
//    }
}
