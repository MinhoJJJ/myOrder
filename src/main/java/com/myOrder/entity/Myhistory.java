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
public class Myhistory {

    @Id
    @Column(name = "LIST_NDX", length = 50)
    private String list_ndx;

    @Column(name = "ID", length = 30)
    private String id;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DESCRIPTION", length = 150)
    private String description;

    @Column(name = "CATEGORY", length = 100)
    private String category;

    @Column(name = "AMOUNT", length = 50)
    private String amount;

    @Column(name = "TYPE", length = 5)
    private String type;

}