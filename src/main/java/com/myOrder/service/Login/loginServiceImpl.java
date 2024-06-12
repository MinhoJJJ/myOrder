package com.myOrder.service.Login;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import org.springframework.web.servlet.LocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;


@Service
@Slf4j
public class loginServiceImpl implements loginService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest request;

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
                }else {
                    message = "로그인 성공";
                    System.err.println("성공");
                    result = "S";
                }
            }else{
                message="아이디를 잘못 입력하셨습니다.";
                result="F";
            }
            resultMap.put("message",message);
            resultMap.put("result",result);


        return resultMap;
    }
    @Override
    //시큐리티 기본 로그인 로직
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("====================loginService.loadUserByUsername 디폴드 로그인 체크 ====================");

        // 사용자의 언어 설정을 가져오는 로직을 추가합니다.

        Member member = new Member();
        memberDto memberDto = new memberDto();

        memberDto.setId(username);
        member = memberRepository.findByUserId(memberDto);
        System.out.println("member.getLang(): "+member.getLang());

        Locale locale;
        if (member.getLang().equals("EN")) {
            locale = Locale.ENGLISH;
        }else if(member.getLang().equals("JP")){
            locale = Locale.JAPANESE;
        }else{
            locale = Locale.KOREAN;
        }
        localeResolver.setLocale(request, null, locale); // 로그인시 세션로케일에 언어설정을 전달


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

