package com.myOrder.repositories.category;
import com.myOrder.dto.categoryDto;

public interface CustomCategoryRepository {
    int insertInComeCategory(String id);
    int insertExpenditureCategory(String id);
}
