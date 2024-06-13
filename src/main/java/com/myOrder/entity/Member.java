package com.myOrder.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "user_info")
@Getter
@Setter
public class Member {

    @Id
    @Getter
    @Setter
    @Column(name = "ID")
    private String id;

    @Getter
    @Setter
    @Column(name = "PASSWORD")
    private String password;

    @Getter
    @Setter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Setter
    @Column(name = "AUTH")
    private String auth;

    @Getter
    @Setter
    @Column(name = "JOINDATE")
    private LocalDate joinDate;

    @Getter
    @Setter
    @Column(name = "LANG")
    private String lang;

    @Getter
    @Setter
    @Column(name = "UPT_DT")
    private LocalDate upt_dt;

    @Getter
    @Setter
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Getter
    @Setter
    @Column(name = "EMAIL")
    private String email;

    @Getter
    @Setter
    @Column(name = "CURRENCY")
    private String currency;

}