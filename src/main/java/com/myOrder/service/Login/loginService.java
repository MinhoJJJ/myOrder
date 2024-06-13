package com.myOrder.service.Login;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface loginService extends UserDetailsService {
     /**
      * 유저 중복 체크
      * @return HashMap<String, Object>
      * @throws Exception
      * @author 정민호
      * @since 2024. 06. 13.
      */
     HashMap<String, Object> findByUserInfo(memberDto memberDto) throws Exception;

}
