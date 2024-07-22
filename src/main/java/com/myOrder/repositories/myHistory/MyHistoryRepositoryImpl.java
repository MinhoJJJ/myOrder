package com.myOrder.repositories.myHistory;
import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import com.myOrder.entity.QMyhistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.EntityManager;
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
                .fetch();
    }
}