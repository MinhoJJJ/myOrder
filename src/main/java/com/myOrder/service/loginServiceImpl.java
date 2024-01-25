package com.myOrder.service;

import com.myOrder.dto.loginDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class loginServiceImpl implements loginService {

    @Autowired
    MemberRepository memberRepository;
    public String findByUserName(loginDto loginDto) {
        String userId=loginDto.getUserId();
        Member member = memberRepository.findByUserId(userId);
        String userName =member.getUserName();
        return userName;
    }
}
