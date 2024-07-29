package com.myOrder.repositories.category;
import com.myOrder.dto.categoryDto;
import com.myOrder.entity.Category;
import org.springframework.data.jpa.repository.Query;

public interface CustomCategoryRepository {
    int insertCategory(int index, String id,String gubun, String categoryName, String color, int number);
    Category findMyCategoryById(String id, String gubun);
    int updateCategory(String id,String gubun, String categoryName, String color, int number);

}
