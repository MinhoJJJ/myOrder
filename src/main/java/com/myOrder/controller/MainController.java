package com.myOrder.controller;


import com.myOrder.dto.memberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
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


    // 레스트 컨트롤러 아닌 방식
//    @GetMapping("/")
//    public String main() {
//        return "/login/loginForm.html";
//    }
}
