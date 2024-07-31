package com.myOrder.service.category;
import com.myOrder.entity.Category;
import com.myOrder.repositories.category.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class categoryServiceImpl implements categoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // 카테고리 추가
    public int addCategory(String id,String type, String gubun, String main_category, String sub_category, String color) {

        // 추가하는 카테고리 중복체크
        Category resultCategory = categoryRepository.findMyCategoryById(id, type, gubun, main_category, sub_category);

        // 오류 구분값
        int cnt=0;

        // 카테고리 추가
        if (resultCategory == null) {
            int index =generateNextIndex();
            categoryRepository.insertCategory(index, id, type, gubun, main_category, sub_category, color);
            cnt++;
        }
        return cnt;
    }

    // 인덱스 생성
    public int generateNextIndex() {
        // Generate the next index logic here
        return categoryRepository.findMaxIndex() + 1;
    }

}

