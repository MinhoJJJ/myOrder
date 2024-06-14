package com.myOrder.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String uri = request.getRequestURL().toString();


            log.info("┌Request Param───────────────────────────────────────────────────────────────");
            log.info(" requestURI - "+uri);
            log.info(" Controller Claㄴㄴㄴss : "+handlerMethod.getBeanType().getSimpleName());
            log.info(" Controller Claㄴㄴㄴss : "+handlerMethod.getBeanType().getSimpleName());
            log.info(" method - "+handlerMethod.getMethod().getName());
            Enumeration<String> parameterNames = request.getParameterNames();
            if(parameterNames.hasMoreElements()) {
                while (parameterNames.hasMoreElements()) {
                    String paramName = parameterNames.nextElement();
                    log.info(" "+paramName+" - "+ request.getParameter(paramName));
                }
            }
            log.info("└────────────────────────────────────────────────────────────────────────────");

        }
        return true;
    }
}