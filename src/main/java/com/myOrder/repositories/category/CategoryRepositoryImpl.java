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
    public int insertCategory(int index,String id, String type, String gubun, String main_category,String sub_category, String color){

        //String query = String.format("INSERT INTO user_category (index, ID, TYPE, GUBUN, %s, %s) VALUES (?, ?, ?, ?, ?)", category,categoryColor);
        if(type.equals("M")){
            // 쿼리문 생성
            String query = String.format("INSERT INTO user_category (index, ID, TYPE, GUBUN, MAIN_CATEGORY, MAIN_CATEGORY_COLOR) VALUES (?, ?, ?, ?, ?, ?");

            // 쿼리 실행
            int rowsInserted = entityManager.createNativeQuery(query)
                    .setParameter(1, index)
                    .setParameter(2, id)
                    .setParameter(3, type)
                    .setParameter(4, gubun)
                    .setParameter(5, main_category)
                    .setParameter(6, color)
                    .executeUpdate();
            return 1;
        }else{
            // 쿼리문 생성
            String query = String.format("INSERT INTO user_category (index, ID, TYPE, GUBUN, MAIN_CATEGORY, SUB_CATEGORY) VALUES (?, ?, ?, ?, ?, ?");

            // 쿼리 실행
            int rowsInserted = entityManager.createNativeQuery(query)
                    .setParameter(1, index)
                    .setParameter(2, id)
                    .setParameter(3, type)
                    .setParameter(4, gubun)
                    .setParameter(5, main_category)
                    .setParameter(6, sub_category)
                    .executeUpdate();
            return 1;
        }
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
    public Category findMyCategoryById(String id, String type, String gubun, String main_category, String sub_category){
        if(gubun.equals("M")){
            BooleanBuilder builder = new BooleanBuilder();
            builder.and(qCategory.id.eq(id));
            builder.and(qCategory.gubun.eq(gubun));
            builder.and(qCategory.gubun.eq(type));

            return (Category) queryFactory
                    .selectFrom(qCategory)
                    .where(builder)
                    .fetchOne();
        }

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qCategory.id.eq(id));
        builder.and(qCategory.gubun.eq(gubun));

        return (Category) queryFactory
                .selectFrom(qCategory)
                .where(builder)
                .fetchOne();
    }
}
