package com.myOrder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_category")
@Getter
@Setter
public class Category {

    @Id
    @Column(name = "INDEX")
    private int index;

    @Column(name = "ID", length = 100)
    private String id;

    //수입,지출 카테고리 타입  (I: 수입 , E: 지출)
    @Column(name = "TYPE", length = 10)
    private String type;

    //카테고리 대분류, 소분류 (M: 대분류 , S: 소분류)
    @Column(name = "GUBUN", length = 10)
    private String gubun;

    //대분류 카테고리
    @Column(name = "MAIN_CATEGORY", length = 1000)
    private String main_category;

    //대분류 색상
    @Column(name = "MAIN_CATEGORY_COLOR", length = 1000)
    private String main_category_color;

    //소분류 카테고리
    @Column(name = "SUB_CATEGORY", length = 1000)
    private String sub_category;
}