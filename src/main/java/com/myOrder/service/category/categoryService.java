package com.myOrder.service.category;
import com.myOrder.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface categoryService{

    int addCategory(String id,String type, String gubun, String main_category, String sub_category, String color) throws Exception;

    int generateNextIndex() throws Exception;

    //List<String> findMyCategoryListById() throws Exception;

}
