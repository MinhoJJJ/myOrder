package com.myOrder.repositories;

import com.myOrder.entity.Member;
import com.myOrder.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   //생성자를 자동으로 만들어주는 어노테이션
public class MemberRepositoryImpl implements CustomMemberRepository{

    final JPAQueryFactory query;
    QMember qMember = QMember.member;

    @Override
    public Member findByUserId2(String userId) {
        return query
                .selectFrom(qMember)
                .where(qMember.userId.eq(userId))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }

}
