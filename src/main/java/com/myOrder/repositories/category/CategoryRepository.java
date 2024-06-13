package com.myOrder.repositories.category;

import com.myOrder.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CustomCategoryRepository {
}
