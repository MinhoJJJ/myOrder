package com.myOrder.service.SignUpAndModify;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.member.MemberRepository;
import com.myOrder.repositories.category.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class signUpAndModifyServiceImpl implements signUpAndModifyService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public HashMap<String, Object> checkDuplicateId(memberDto memberDto) {
        Member member = new Member();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String result = null;
            member = memberRepository.findByUserId(memberDto);
            if (member != null) {
                result = "S";
            }else{
                result="F";
            }
            resultMap.put("result",result);
        return resultMap;
    }

    public HashMap<String, Object> signUpMember(memberDto memberDto) {

        Member member = new Member();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        String message = null;
        String result = null;
        memberDto.setLang("KR");  // 언어기본값 한국어로 설정
        int chk=memberRepository.insertMember(memberDto);
        chk+=categoryRepository.insertInComeCategory(memberDto.getId());
        chk+=categoryRepository.insertExpenditureCategory(memberDto.getId());

        if(chk > 2){
            message="회원가입에 성공하였습니다..";
            result="S";
        }else{
            message="회원가입에 실패하였습니다.";
            result="F";
        }

        resultMap.put("message",message);
        resultMap.put("result",result);

        return resultMap;
    }

}

