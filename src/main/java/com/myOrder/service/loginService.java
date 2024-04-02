package com.myOrder.service;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface loginService {
     HashMap<String, Object> findByUserInfo(memberDto memberDto) throws Exception;

     HashMap<String, Object> signUpMember(memberDto memberDto) throws Exception;

}
