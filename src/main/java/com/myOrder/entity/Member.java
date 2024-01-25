package com.myOrder.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_info")
@Getter
@Setter
//@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "user_id")
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
