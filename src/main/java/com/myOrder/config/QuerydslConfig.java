package com.myOrder.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          //스프링 기반의 설정파일
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory query() {
        return new JPAQueryFactory(entityManager);
    }
}
