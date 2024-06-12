package com.myOrder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

/*
    1. 스프링 프레임워크에서 제공하는 인터페이스이다.
    2. 보일러플레이트 코드 없이 요구사항에 맞게 프레임워크를 조정할 수 있게 해준다.
    3. 특정한 스프링 클래스를 구현하거나 상속할 필요 없이 MVC 구성정보를 제어할 수 있게 해준다.
    4. @EnableWebMvc 를 통해 활성화된 Web MVC 애플리케이션의 구성정보를 커스터마이징하는 것을 돕기도 한다.
    5. 스프링 부트에 있는 기본 설정이 마음에 들지 않거나 스프링에 추가적인 설정을 해줄 필요가 있을 때 사용한다.
*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {         //request 를 핸들링 하기 전 후로 처리할 작업이 있을 때 이를 위한 커스텀 인터셉터를 구성하는 용도로 사용할 수 있다.
   /*
        LocaleChangeInterceptor는 사용자가 url를 통해서 언어를 변경할 경우 사용한다.
        Spring MVC에서 controller를 통해서 접근시 가로채서 LocaleChangeInterceptor를 적용하게 된다.
    */
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang"); // 요청 파라미터 이름 설정
        registry.addInterceptor(localeChangeInterceptor);
    }
}