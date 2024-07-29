package com.myOrder.repositories.category;

import com.myOrder.dto.categoryDto;
import com.myOrder.dto.memberDto;
import com.myOrder.entity.Category;
import com.myOrder.entity.QCategory;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor   //생성자를 자동으로 만들어주는 어노테이션
public class CategoryRepositoryImpl implements CustomCategoryRepository {

    final JPAQueryFactory queryFactory;
    QCategory qCategory = QCategory.category;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public int insertCategory(int index,String id,String gubun, String categoryName, String color, int number){

        // 동적 컬럼 이름 생성
        String category = "category"+number;
        String categoryColor = "color"+number;

        // 쿼리 문자열 동적 생성
        String query = String.format("INSERT INTO user_category (index, ID, GUBUN, %s, %s) VALUES (?, ?, ?, ?, ?)", category,categoryColor);

        // 쿼리 실행
        int rowsInserted = entityManager.createNativeQuery(query)
                .setParameter(1, index)
                .setParameter(2, id)
                .setParameter(3, gubun)
                .setParameter(4, categoryName)
                .setParameter(5, color)
                .executeUpdate();
        return 1;
    }

    @Override
    @Transactional
    public int updateCategory(String id, String gubun, String categoryName, String color, int number) {
        // 동적 컬럼 이름 생성
        String category = "category" + number;
        String categoryColor = "color" + number;

        // 동적 UPDATE 쿼리 생성
        String query = String.format("UPDATE user_category SET %s = ?, %s = ? WHERE ID = ? AND gubun = ?", category, categoryColor);

        // 쿼리 실행
        int rowsUpdated = entityManager.createNativeQuery(query)
                .setParameter(1, categoryName) // 카테고리 이름
                .setParameter(2, color) // 색상
                .setParameter(3, id) // ID
                .setParameter(4, gubun) // 구분
                .executeUpdate();

        return rowsUpdated; // 업데이트된 행 수를 반환
    }

    @Override
    @Transactional
    public Category findMyCategoryById(String id, String gubun){

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qCategory.id.eq(id));
        builder.and(qCategory.gubun.eq(gubun));

        return (Category) queryFactory
                .selectFrom(qCategory)
                .where(builder)
                .fetchOne();
    }
}
