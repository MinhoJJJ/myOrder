package com.myOrder.service;

import com.myOrder.dto.memberDto;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
    public String findByUserName(memberDto memberDto);
}
