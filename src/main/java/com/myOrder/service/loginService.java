package com.myOrder.service;

import com.myOrder.dto.loginDto;
import com.myOrder.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface loginService {
    public String findByUserName(loginDto loginDto);
}
