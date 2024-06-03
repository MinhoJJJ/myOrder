package com.myOrder.entity;

import lombok.*;
import jakarta.persistence.*;


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
    private String joinDate;

    @Getter
    @Column(name = "LANG")
    private String lang;

    public void setId(String id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setName(String name) {this.name = name;}
    public void setAuth(String auth) {this.auth = auth;}
    public void setJoinDate(String joinDate) {this.joinDate = joinDate;}
    public void setLang(String lang) {this.lang = lang;}


}