package com.myOrder.service.SignUpAndModify;

import com.myOrder.dto.memberDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface signUpAndModifyService{
     HashMap<String, Object> checkDuplicateId(memberDto memberDto) throws Exception;
     HashMap<String, Object> signUpMember(memberDto memberDto) throws Exception;

}
