package com.myOrder.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.myOrder.service.category.categoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class SettingController {

    @Autowired
    categoryService categoryService;

    //카테고리 추가
      @RequestMapping("/addCategory.do")
      public HashMap<String, Object> addCategory(
              @RequestParam String id ,
              @RequestParam String type,
              @RequestParam String gubun,
              @RequestParam String main_category,
              @RequestParam String sub_category,
              @RequestParam String color)
      {

          HashMap<String, Object> response = new HashMap<>();

          try {

              // 서비스단으로 이동
              int cnt=categoryService.addCategory(id, type, gubun, main_category, sub_category, color);
              if(cnt == 0){
                  response.put("result", "F");
                  response.put("message", "카테고리 추가에 실패하였습니다.");
              }else if(cnt == 9){
                  response.put("result", "F");
                  response.put("message", "카테고리 갯수가 최대입니다. (10개)");
              }else{
                  response.put("result", "S");
                  response.put("message", "카테고리 추가에 성공하였습니다.");
              }
              response.put("result", "S");
          } catch (Exception e) {
              response.put("result", "F");
              response.put("message", e.getMessage());
          }

          return response;
      }
    //내 카테고리 불러오기
    @RequestMapping("/findMyCategoryListById.do")
    public HashMap<String, Object> findMyCategoryListById(@RequestParam String id) {

        HashMap<String, Object> response = new HashMap<>();

        try {

//            // 대분류 지출 카테고리 불러오기
//            int cnt=categoryService.findMyCategoryListById(id);
//            // 소분류 지출 카테고리 불러오기
//            int cnt=categoryService.findMyCategoryListById(id);
//            // 대분류 수입 카테고리 불러오기
//            int cnt=categoryService.findMyCategoryListById(id);
//            // 소분류 수입 카테고리 불러오기
//
//            int cnt=categoryService.findMyCategoryListById(id);
            int cnt=0;
            if(cnt == 0){
                response.put("result", "F");
                response.put("message", "카테고리 추가에 실패하였습니다.");
            }else if(cnt == 9){
                response.put("result", "F");
                response.put("message", "카테고리 갯수가 최대입니다. (10개)");
            }else{
                response.put("result", "S");
                response.put("message", "카테고리 추가에 성공하였습니다.");
            }
            response.put("result", "S");
        } catch (Exception e) {
            response.put("result", "F");
            response.put("message", e.getMessage());
        }

        return response;
    }

}
