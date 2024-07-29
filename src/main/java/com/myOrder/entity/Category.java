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

    //수입,지출 카테고리 구분
    @Column(name = "GUBUN", length = 50)
    private String gubun;

    @Column(name = "CATEGORY1", length = 50)
    private String category1;

    @Column(name = "CATEGORY2", length = 50)
    private String category2;

    @Column(name = "CATEGORY3", length = 50)
    private String category3;

    @Column(name = "CATEGORY4", length = 50)
    private String category4;

    @Column(name = "CATEGORY5", length = 50)
    private String category5;

    @Column(name = "CATEGORY6", length = 50)
    private String category6;

    @Column(name = "CATEGORY7", length = 50)
    private String category7;

    @Column(name = "CATEGORY8", length = 50)
    private String category8;

    @Column(name = "CATEGORY9", length = 50)
    private String category9;

    @Column(name = "CATEGORY10", length = 50)
    private String category10;

    @Column(name = "COLOR1", length = 20)
    private String color1;

    @Column(name = "COLOR2", length = 20)
    private String color2;

    @Column(name = "COLOR3", length = 20)
    private String color3;

    @Column(name = "COLOR4", length = 20)
    private String color4;

    @Column(name = "COLOR5", length = 20)
    private String color5;

    @Column(name = "COLOR6", length = 20)
    private String color6;

    @Column(name = "COLOR7", length = 20)
    private String color7;

    @Column(name = "COLOR8", length = 20)
    private String color8;

    @Column(name = "COLOR9", length = 20)
    private String color9;

    @Column(name = "COLOR10", length = 20)
    private String color10;
}