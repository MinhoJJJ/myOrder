package com.myOrder.repositories.category;

import com.myOrder.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CustomCategoryRepository {
    // 인덱스의 최대값을 조회하는 메소드
    @Query("SELECT COALESCE(MAX(c.index), 0) FROM Category c")
    int findMaxIndex();
}
