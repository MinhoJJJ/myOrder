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

import java.time.LocalDate;

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
                .where(qMember.id.eq(memberDto.getId()))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }
    @Override
    public Member findByUserPw(memberDto memberDto) {
        return query
                .selectFrom(qMember)
                .where(qMember.id.eq(memberDto.getId()).and(qMember.password.eq(memberDto.getPassword())))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }

    @Override
    @Transactional
    public int insertMember(memberDto memberDto) {
        entityManager.createNativeQuery("INSERT INTO user_info (ID,PASSWORD,NAME,LANG,BIRTHDAY,EMAIL,JOINDATE,AUTH,CURRENCY) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)")
                .setParameter(1, memberDto.getId())
                .setParameter(2, memberDto.getPassword())
                .setParameter(3, memberDto.getName())
                .setParameter(4, "KR")
                .setParameter(5, memberDto.getBirthday())
                .setParameter(6, memberDto.getEmail())
                .setParameter(7, LocalDate.now())
                .setParameter(8, "01")
                .setParameter(9, "KRW")
                .executeUpdate();
        return 1;
    }

}
