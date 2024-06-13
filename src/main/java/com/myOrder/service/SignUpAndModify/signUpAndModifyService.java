package com.myOrder.service.SignUpAndModify;

import com.myOrder.dto.memberDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface signUpAndModifyService{
     /**
      * 아이디 비밀번호 유효성 체크
      * @return HashMap<String, Object>
      * @throws Exception
      * @author 정민호
      * @since 2024. 06. 13.
      */
     HashMap<String, Object> checkDuplicateId(memberDto memberDto) throws Exception;
     /**
      * 회원가입
      * @return HashMap<String, Object>
      * @throws Exception
      * @author 정민호
      * @since 2024. 06. 13.
      */
     HashMap<String, Object> signUpMember(memberDto memberDto) throws Exception;

}
