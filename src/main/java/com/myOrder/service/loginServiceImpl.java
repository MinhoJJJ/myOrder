package com.myOrder.service;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    MemberRepository memberRepository;
    public HashMap<String, Object> findByUserInfo(memberDto memberDto) {
        Member member = new Member();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        String message = null;
        String result = null;

            member = memberRepository.findByUserId(memberDto);
            if (member != null) {
                member = memberRepository.findByUserPw(memberDto);
                if (member == null) {
                    message="패스워드를 잘못 입력하셨습니다.";
                    result="F";
                }else{
                    message="로그인성공.";
                    result="S";
                    resultMap.put("userName",member.getUserName());
                }
            }else{
                message="아이디를 잘못 입력하셨습니다.";
                result="F";
            }
            resultMap.put("message",message);
            resultMap.put("result",result);


        return resultMap;
    }
}
