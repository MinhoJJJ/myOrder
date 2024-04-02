package com.myOrder.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration        // 해당 클래스를 빈으로 지정하도록 하는 어노테이션
@EnableWebSecurity    // 해당 클래스가 스프링 시큐리티 설정을 정의한다는 것을 나타냄
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    // 보안필터 체인을 정의하는 빈(메서드)
        System.err.println("여기들어옴");
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz                      // HTTP 요청에 대한 인증 및 인가 규칙을 설정
                        .requestMatchers("/login/login.do", "/h2-console/**").permitAll()
                        .requestMatchers("/login/main.do").authenticated() // 대시보드 페이지는 인증된 사용자만 접근 가능하도록 설정
                        .anyRequest().permitAll()                            // 다른 모든 요청은 인증 없이 접근 가능하도록 설정
                )
                .formLogin(form -> form                                      // 폼 기반 로그인을 활성화하고, 로그인 페이지를 지정
                        .loginPage("/login")                                 // 로그인 페이지 경로 설정
                        .permitAll()
                );
        return http.build();    //만들어진 보안구성객체를 반환
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers(PathRequest
                        .toStaticResources()
                        .atCommonLocations()
                );
    }
}