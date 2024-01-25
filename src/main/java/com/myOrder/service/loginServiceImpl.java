package com.myOrder.service;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    MemberRepository memberRepository;
    public String findByUserName(memberDto memberDto) {
        String userId= memberDto.getUserId();
        Member member = memberRepository.findByUserId(userId);
        String userName =member.getUserName();
        return userName;
    }
}
