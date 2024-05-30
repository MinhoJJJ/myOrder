package com.myOrder.service.Login;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface loginService extends UserDetailsService {
     HashMap<String, Object> findByUserInfo(memberDto memberDto) throws Exception;

}
