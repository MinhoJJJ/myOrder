package com.myOrder.repositories;

import com.myOrder.entity.Member;
import com.myOrder.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements CustomMemberRepository{

    final JPAQueryFactory query;
    QMember qMember = QMember.member;

    @Override
    public Member findByUserId2(String userId) {
        return query
                .selectFrom(qMember)
                .where(qMember.userId.eq(userId))
                .fetchOne();
    }

}
