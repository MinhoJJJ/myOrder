package com.myOrder.repositories.myHistory;

import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import com.myOrder.entity.QMyhistory;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@RequiredArgsConstructor
public class MyHistoryRepositoryImpl implements CustomMyHistoryRepository {

    final JPAQueryFactory queryFactory;
    QMyhistory qMyhistory = QMyhistory.myhistory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Myhistory> findMyHistoryById(Member member) {
        return queryFactory
                .selectFrom(qMyhistory)
                .where(qMyhistory.id.eq(member.getId()))
                .orderBy(qMyhistory.date.desc())
                .fetch();
    }
    @Override
    public List<Myhistory> findMyHistoryByIdAndType(String type,String id, int month) {

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qMyhistory.id.eq(id));
        builder.and(qMyhistory.type.eq(type));

        // 현재 년도 가져오기
        int year = LocalDate.now().getYear();

        // 해당 월의 시작일과 끝일 계산
        LocalDate startOfMonth = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

        // 날짜 조건 추가
        builder.and(qMyhistory.date.between(startOfMonth, endOfMonth));

        return queryFactory
                .selectFrom(qMyhistory)
                .where(builder)
                .orderBy(qMyhistory.date.desc())
                .fetch();
    }
}