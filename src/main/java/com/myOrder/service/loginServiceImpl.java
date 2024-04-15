package com.myOrder.service;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    MemberRepository memberRepository;
    public HashMap<String, Object> findByUserInfo(memberDto memberDto) {
        Member member = new Member();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        String message = null;
        String result = null;

            member = memberRepository.findByUserId(memberDto);
            if (member != null) {
                member = memberRepository.findByUserPw(memberDto);
                if (member == null) {
                    message="패스워드를 잘못 입력하셨습니다.";
                    result="F";
                }else{
                    message="로그인 성공";
                    result="S";
                    resultMap.put("userName",member.getName());
                }
            }else{
                message="아이디를 잘못 입력하셨습니다.";
                result="F";
            }
            resultMap.put("message",message);
            resultMap.put("result",result);


        return resultMap;
    }
    public HashMap<String, Object> signUpMember(memberDto memberDto) {

        Member member = new Member();
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        String message = null;
        String result = null;

        member = memberRepository.findByUserId(memberDto);
        if (member != null) {
            message="이미 존재하는 아이디 입니다.";
            result="F";
        }else{
            int chk=memberRepository.insertMember(memberDto);
            if(chk > 0){
                message="회원가입에 성공하였습니다..";
                result="S";
            }else{
                message="회원가입에 실패하였습니다.";
                result="F";
            }
        }
        resultMap.put("message",message);
        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     System.err.println("username: "+username);
     Member member = new Member();
     memberDto memberDto = new memberDto();

     memberDto.setId(username);
     member = memberRepository.findByUserId(memberDto);
        System.err.println("getId: "+member.getId());
        System.err.println("getName: "+member.getName());
        System.err.println("getPassword: "+member.getPassword());

        String[] auth = {"ROLE_USER", "ROLE_ADMIN"};
         if(member != null) { // 조회된 회원이 있다면
             return User.builder()
                .username(member.getId())
                .password(member.getPassword())
                .roles(member.getAuth()) //"USER"로 접두사를 필요로 하지않을때 사용가능
                // .authorities(AuthorityUtils.createAuthorityList(Arrays.asList(auth)))
                // "ROLE_" 접두사가 포함되어 있고 List 형태어이야 함
                .build();
         }else {
             throw new UsernameNotFoundException("조회된 회원이 없습니다");
         }
    }
}

