package com.myOrder.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class myHistoryDto {

    @Getter @Setter
    private int list_ndx;

    @Getter @Setter
    private String id;

    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String category;

    @Getter @Setter
    private String amount;

    @Getter @Setter
    private String type;
}
