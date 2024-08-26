package com.myOrder.repositories.category;
import com.myOrder.dto.categoryDto;
import com.myOrder.entity.Category;
import org.springframework.data.jpa.repository.Query;

public interface CustomCategoryRepository {
    int insertCategory(int index,String id, String type, String gubun, String main_category,String sub_category, String color);
    Category findMyCategoryById(String id, String type, String gubun, String main_category, String sub_category);
    int updateCategory(String id,String gubun, String categoryName, String color, int number);

}
