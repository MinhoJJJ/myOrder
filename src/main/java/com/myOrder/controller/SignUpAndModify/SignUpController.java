package com.myOrder.controller.SignUpAndModify;

import com.myOrder.dto.memberDto;
import com.myOrder.service.Login.loginService;
import com.myOrder.service.SignUpAndModify.signUpAndModifyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignUpController {
    private final signUpAndModifyService signUpAndModifyService;

    @RequestMapping("/checkDuplicateIdAjax.do")
    public HashMap<String, Object> checkDuplicateIdAjax(memberDto memberDto, HttpServletRequest request) throws Exception {

        log.info("====================SignUpController.checkDuplicateIdAjax 아이디 중복체크====================");
        // 아이디 비밀번호 유효성 체크 (중복시 S값 , 아닐시 F)
        return signUpAndModifyService.checkDuplicateId(memberDto);

    }

//    @RequestMapping("/signUp22.do")
//    public HashMap<String, Object> signUp(memberDto memberDto,HttpServletRequest request) throws Exception {
//
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap=loginService.signUpMember(memberDto);
//        return resultMap;
//    }

}