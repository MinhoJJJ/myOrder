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

    /**
     * 로그인 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @GetMapping("/")
    public ModelAndView start(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception) {

        ModelAndView modelAndView;
        modelAndView = new ModelAndView("login/loginForm");

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 메인 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/main.do")
    public ModelAndView moveMain(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/main");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 거래추가 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/transaction.do")
    public ModelAndView moveTransation(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/transaction");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 헤더단 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/header.do")
    public ModelAndView moveHeader(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/header");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 보고서 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/report.do")
    public ModelAndView moveReport(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/report");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 설정 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/setting.do")
    public ModelAndView moveSetting(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/setting");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 회원정보 수정 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/modify.do")
    public ModelAndView moveModify(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/modify");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 전체내역 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/totalList.do")
    public ModelAndView moveTotalList(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("main/totalList");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    /**
     * 회원가입 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/moveSignUp.do")
    public ModelAndView moveSignUp(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "exception", required = false) String exception, HttpServletRequest request) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("login/signUp");
        HttpSession session = request.getSession(true);

        modelAndView.addObject("error", error);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

}
