package com.myOrder.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class myHistoryDto {

    private int list_ndx;

    private String id;

    private LocalDate date;

    private String description;

    private String category;

    private int amount;

    private String type;
}
