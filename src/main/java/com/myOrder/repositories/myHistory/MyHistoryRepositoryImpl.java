package com.myOrder.repositories.myHistory;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.entity.MyHistory;
import com.myOrder.entity.QCategory;
import com.myOrder.entity.QMyHistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   //생성자를 자동으로 만들어주는 어노테이션
public class MyHistoryRepositoryImpl implements CustomMyHistoryRepository {

    final JPAQueryFactory query;
    QMyHistory qMyHistory = QMyHistory.myHistory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MyHistory findMyHistory(memberDto memberDto){
        return query
                .selectFrom(qMyHistory)
                .where(qMyHistory.id.eq(memberDto.getId()))
                .fetchOne();  //QueryDSL의 메서드 중 하나로, 쿼리를 실행하고 결과를 가져오는 역할을 합니다.
    }


}
