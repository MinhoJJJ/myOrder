package com.myOrder.dto;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class memberDto {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String auth;
    @Getter
    @Setter
    private LocalDate joinDate;
    @Getter
    @Setter
    private String lang;
    @Getter
    @Setter
    private LocalDate birthday;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private LocalDate upt_dt;
    @Getter
    @Setter
    private String currency;

}
