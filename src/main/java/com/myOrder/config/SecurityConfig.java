package com.myOrder.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration        // 해당 클래스를 빈으로 지정하도록 하는 어노테이션
@EnableWebSecurity    // 해당 클래스가 스프링 시큐리티 설정을 정의한다는 것을 나타냄
@RequiredArgsConstructor

public class SecurityConfig {

    private final AuthenticationFailureHandler LoginFailureHandler;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    // 보안필터 체인을 정의하는 빈(메서드)
        http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request                 // HTTP 요청에 대한 인증 및 인가 규칙을 설정
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() // FORWARD 디스패처에 대해 허용
                        .requestMatchers("/img/**","/css/**","/js/**","/signUp.do","/moveSignUp.do","/checkDuplicateIdAjax.do").permitAll() // 추가적인 요청을 인증제외을 허용
                        .anyRequest().authenticated() // 모든 요청에 대해 인증 필요
                )
                .formLogin(login -> login
                        .loginPage("/")
                        .loginProcessingUrl("/login.do")   //  "/login" 말고 login을 해야 정상적으로 작동  여기서 / 의 역할은 상대경로인지 절대경로인지
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .failureHandler(LoginFailureHandler)   //로그인 실패시 핸들러 타도록
                        .defaultSuccessUrl("/main.do", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout.do") // 로그아웃 URL 지정
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 리다이렉트할 URL 지정
                        .invalidateHttpSession(true) // HTTP 세션 무효화
                        .deleteCookies("JSESSIONID") // 쿠키 삭제
                )
        ;
        return http.build();    //만들어진 보안구성객체를 반환
    }

    @Bean
    public PasswordEncoder loginPasswordEncoder() {
        return new NoPasswordEncoder();
    }


}