package com.myOrder.entity;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "user_info")
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_name")
    private String userName;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw = userPw; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

}