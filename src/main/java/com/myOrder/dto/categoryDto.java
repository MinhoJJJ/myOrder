package com.myOrder.dto;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter

public class categoryDto {

    private int index;

    private String id;

    private String type;                 //수입,지출 카테고리 타입  (I: 수입 , E: 지출)

    private String gubun;                //카테고리 대분류, 소분류 (M: 대분류 , S: 소분류)

    private String main_category;        //대분류 카테고리

    private String main_category_color;  //대분류 색상

    private String sub_category;         //소분류 카테고리

}
