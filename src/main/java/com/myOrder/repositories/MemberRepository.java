package com.myOrder.repositories;

import com.myOrder.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
//import com.querydsl.jpa.impl.JPAQueryFactory;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);

//    // 더 복잡한 동적 쿼리
//    default Member findByDynamicConditions(String userId, String otherField) {
//        QMember member = QMember.member;
//        return new JPAQueryFactory(getEntityManager())
//                .selectFrom(member)
//                .where(member.userId.eq(userId).and(member.someOtherField.eq(otherField)))
//                .fetchOne();
//    }
}

//
//    plugins {
//        id 'org.springframework.boot' version '2.5.5' // 또는 다른 버전
//        id 'io.spring.dependency-management' version '1.0.11.RELEASE'
//        id 'java'
//        id 'net.ltgt.apt' version '0.21' // apt 플러그인 추가
//    }
//
//    dependencyManagement {
//        imports {
//            // QueryDSL 버전 설정
//            mavenBom "com.querydsl:querydsl-bom:4.4.0" // 최신 버전 확인 필요
//        }
//    }
//
//    dependencies {
//        implementation 'com.querydsl:querydsl-jpa'
//        annotationProcessor 'com.querydsl:querydsl-apt:4.4.0:jpa' // QueryDSL apt 플러그인 추가
//        annotationProcessor 'jakarta.persistence:jakarta.persistence-api:2.2' // JPA API 의존성 추가
//        // ...
//    }