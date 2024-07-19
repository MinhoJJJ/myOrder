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

    @Column(name = "ID")
    private String id;

    @Column(name = "GUBUN")
    private String gubun;                 //수입,지출 카테고리 구분

    @Column(name = "CATEGORY1")
    private String category1;

    @Column(name = "CATEGORY2")
    private String category2;

    @Column(name = "CATEGORY3")
    private String category3;

    @Column(name = "CATEGORY4")
    private String category4;

    @Column(name = "CATEGORY5")
    private String category5;

    @Column(name = "CATEGORY6")
    private String category6;

    @Column(name = "CATEGORY7")
    private String category7;

    @Column(name = "CATEGORY8")
    private String category8;

    @Column(name = "CATEGORY9")
    private String category9;

    @Column(name = "CATEGORY10")
    private String category10;
}