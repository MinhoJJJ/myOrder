package com.myOrder.repositories.category;
import com.myOrder.dto.categoryDto;
import com.myOrder.entity.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomCategoryRepository {
    int insertCategory(int index,String id, String type, String gubun, String main_category,String sub_category, String color);
    Category findMyCategoryById(String id, String type, String gubun, String main_category, String sub_category);
    List<String> findMyCategoryListById(String id, String type, String gubun, String main_category);
    int updateCategory(String id,String gubun, String categoryName, String color, int number);

}
