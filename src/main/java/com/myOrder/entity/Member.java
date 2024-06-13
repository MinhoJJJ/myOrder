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
    @Column(name = "ID")
    private String id;

    @Getter
    @Column(name = "PASSWORD")
    private String password;

    @Getter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Column(name = "AUTH")
    private String auth;

    @Getter
    @Column(name = "JOINDATE")
    private LocalDate joinDate;

    @Getter
    @Column(name = "LANG")
    private String lang;

    @Getter
    @Column(name = "UPT_DT")
    private LocalDate upt_dt;

    @Getter
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Getter
    @Column(name = "EMAIL")
    private String email;

    @Getter
    @Column(name = "CURRENCY")
    private String currency;

    public void setId(String id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setName(String name) {this.name = name;}
    public void setAuth(String auth) {this.auth = auth;}
    public void setJoinDate(LocalDate joinDate) {this.joinDate = joinDate;}
    public void setLang(String lang) {this.lang = lang;}
    public void setUpt_dt(LocalDate upt_dt) { this.upt_dt = upt_dt;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    public void setEmail(String email) {this.email = email;}
    public void setCurrency(String currency) {this.currency = currency;}



}