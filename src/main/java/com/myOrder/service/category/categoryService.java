package com.myOrder.service.category;
import com.myOrder.entity.Category;
import org.springframework.stereotype.Service;


@Service
public interface categoryService{

    int addOrUpdateCategory(String id, String gubun, String categoryName, String color) throws Exception;

    int generateNextIndex() throws Exception;

    int findNullCategories(Category Category) throws Exception;

}
