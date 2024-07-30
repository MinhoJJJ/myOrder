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
    public int addOrUpdateCategory(String id, String gubun, String categoryName, String color) {

        // 현재 나의 카테고리
        Category resultCategory = categoryRepository.findMyCategoryById(id,gubun);

        // 오류 구분값
        int cnt=0;

        // 카테고리가 하나도 없는 경우 (첫번째 카테고리에 데이터 추가)
        if (resultCategory == null) {
            int index =generateNextIndex();
            categoryRepository.insertCategory(index, id, gubun, categoryName, color, 1);
            cnt++;
        }
        // 카테고리가 있은 경우 (비어져있는 카테고리에 데이터 추가)
        else {
            int number=findNullCategories(resultCategory);
            categoryRepository.updateCategory(id, gubun, categoryName, color, number);

            // 카테고리 10개가 초과한 경우
            if(number != 0){
                cnt++;
            }else{
                cnt=9;
            }
        }
        return cnt;
    }

    // 인덱스 생성
    public int generateNextIndex() {
        // Generate the next index logic here
        return categoryRepository.findMaxIndex() + 1;
    }
    // 비어져있는 카테고리 탐색
    public int findNullCategories(Category Category){
        int index=0;

        String[] categories = { Category.getCategory1() , Category.getCategory2()
                , Category.getCategory3(), Category.getCategory4(), Category.getCategory5()
                , Category.getCategory6(), Category.getCategory7(), Category.getCategory8()
                , Category.getCategory9(), Category.getCategory10()
        };

        // 필드 값을 확인하여 null인 경우 이름을 추가
        for (int i = 0; i < categories.length; i++) {
            if (categories[i] == null) {
                index=i+1;
                break;
            }
        }
        return index;
    }
}

