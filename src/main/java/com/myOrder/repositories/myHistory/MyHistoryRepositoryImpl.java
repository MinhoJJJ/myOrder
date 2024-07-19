package com.myOrder.repositories.myHistory;
import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import com.myOrder.entity.QMyhistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class MyHistoryRepositoryImpl implements CustomMyHistoryRepository {

    private final JPAQueryFactory queryFactory;
    private final QMyhistory qMyhistory = QMyhistory.myhistory;

    public MyHistoryRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Myhistory> findMyHistoryById(Member member) {
        return queryFactory
                .selectFrom(qMyhistory)
                .where(qMyhistory.id.eq(member.getId()))
                .fetch();
    }
}