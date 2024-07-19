package com.myOrder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "myhistory")
@Getter
@Setter
public class MyHistory {

    @Id
    @Getter @Setter
    @Column(name = "LIST_NDX", length = 50)
    private String list_ndx;

    @Getter @Setter
    @Column(name = "ID", length = 30)
    private String id;

    @Getter @Setter
    @Column(name = "DATE")
    private LocalDate date;

    @Getter @Setter
    @Column(name = "DESCRIPTION", length = 150)
    private String description;

    @Getter @Setter
    @Column(name = "CATEGORY", length = 100)
    private String category;

    @Getter
    @Setter
    @Column(name = "AMOUNT", length = 50)
    private String amount;

    @Getter
    @Setter
    @Column(name = "TYPE", length = 5)
    private String type;

}