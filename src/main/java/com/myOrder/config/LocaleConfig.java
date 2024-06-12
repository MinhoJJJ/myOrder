package com.myOrder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

@Configuration
public class LocaleConfig {

    @Bean
    public LocaleResolver localeResolver() {  //Locale : 사용자의 언어, 국가(뿐 아니라 사용자 인터페이스에서 사용자가 선호하는 사항을 지정한 매개변수의 모임)
        // 1. LocaleResolver를 @Bean으로 등록한다. default는 한국어다
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();  //세션으로부터 Locale 정보를 구한다.
        localeResolver.setDefaultLocale(Locale.KOREAN); // 기본 로케일 설정
        return localeResolver;
    }
}