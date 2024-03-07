package com.myOrder.repositories;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.SessionLazyDelegator;

@RequiredArgsConstructor   //생성자를 자동으로 만들어주는 어노테이션
public class MemberRepositoryImpl implements CustomMemberRepository{

    final JPAQueryFactory query;
    QMember qMember = QMember.member;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member findByUserId(memberDto memberDto) {
        return query
                .selectFrom(qMember)
                .where(qMember.userId.eq(memberDto.getUserId()))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }
    @Override
    public Member findByUserPw(memberDto memberDto) {
        return query
                .selectFrom(qMember)
                .where(qMember.userId.eq(memberDto.getUserId()).and(qMember.userPw.eq(memberDto.getUserPw())))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }

    @Override
    @Transactional
    public int insertMember(memberDto memberDto) {
        entityManager.createNativeQuery("INSERT INTO user_info (user_id, user_pw, user_name) VALUES (?, ?, ?)")
                .setParameter(1, memberDto.getUserId())
                .setParameter(2, memberDto.getUserPw())
                .setParameter(3, memberDto.getUserName())
                .executeUpdate();
        return 1;
    }

}
