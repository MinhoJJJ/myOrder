package com.myOrder.repositories.category;

import com.myOrder.dto.categoryDto;
import com.myOrder.dto.memberDto;
import com.myOrder.entity.QCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor   //생성자를 자동으로 만들어주는 어노테이션
public class CategoryRepositoryImpl implements CustomCategoryRepository {

    final JPAQueryFactory query;
    QCategory qMember = QCategory.category;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public int insertInComeCategory(String id) {
        entityManager.createNativeQuery("INSERT INTO user_category (ID,GUBUN) VALUES (?, ?)")
                .setParameter(1, id)
                .setParameter(2, "I")
                .executeUpdate();
        return 1;
    }

    @Override
    @Transactional
    public int insertExpenditureCategory(String id) {
        entityManager.createNativeQuery("INSERT INTO user_category (ID,GUBUN) VALUES (?, ?)")
                .setParameter(1, id)
                .setParameter(2, "E")
                .executeUpdate();
        return 1;
    }
}
