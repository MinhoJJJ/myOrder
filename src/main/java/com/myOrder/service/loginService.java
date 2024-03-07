package com.myOrder.service;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface loginService {
    public HashMap<String, Object> findByUserInfo(memberDto memberDto) throws Exception;

    public HashMap<String, Object> signUpMember(memberDto memberDto) throws Exception;

}
