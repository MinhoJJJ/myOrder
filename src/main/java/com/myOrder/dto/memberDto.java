package com.myOrder.dto;

public class memberDto {
    private String userId;     //유저아이디
    private String userPw;     //유저패스워드
    private String userName;     //유저이름

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw = userPw; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName;}
}
