package com.myOrder.dto;
import java.time.LocalDate;
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
    private LocalDate joinDate;
    @Getter
    private String lang;
    @Getter
    private LocalDate birthday;
    @Getter
    private String email;
    @Getter
    private LocalDate upt_dt;

    public void setId(String id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setName(String name) {this.name = name;}
    public void setAuth(String auth) {this.auth = auth;}
    public void setJoinDate(LocalDate joinDate) {this.joinDate = joinDate;}
    public void setLang(String lang) {this.lang = lang;}
    public void setBirthday(LocalDate birthday) { this.birthday = birthday;}
    public void setEmail(String email) { this.email = email;}
    public void setUpt_dt(LocalDate upt_dt) { this.upt_dt = upt_dt; }


}
