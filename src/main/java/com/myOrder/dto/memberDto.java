package com.myOrder.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;

public class memberDto {

    @Getter
    private String id;
    @Getter
    private String password;
    @Getter
    private String name;
    @Getter
    private String auth;
    @Getter
    private String joinDate;
    @Getter
    private String lang;

    public void setId(String id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setName(String name) {this.name = name;}
    public void setAuth(String auth) {this.auth = auth;}
    public void setJoinDate(String joinDate) {this.joinDate = joinDate;}
    public void setLang(String lang) {this.lang = lang;}

}
