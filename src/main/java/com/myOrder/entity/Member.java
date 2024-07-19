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
    @Column(name = "ID")
    private String id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTH")
    private String auth;                //권한

    @Column(name = "JOINDATE")
    private LocalDate joinDate;         // 가입일

    @Column(name = "LANG")
    private String lang;                // 사용자 언어

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "UPT_DT")
    private LocalDate upt_dt;           // 수정일

    @Column(name = "CURRENCY")
    private String currency;            // 사용자 통화

}