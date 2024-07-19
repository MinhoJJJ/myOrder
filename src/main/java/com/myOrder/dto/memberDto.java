package com.myOrder.dto;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class memberDto {

    private String id;

    private String password;

    private String name;

    private String auth;                //권한

    private LocalDate joinDate;         // 가입일

    private String lang;                // 사용자 언어

    private LocalDate birthday;         // 생년월일

    private String email;

    private LocalDate upt_dt;           // 수정일

    private String currency;            // 사용자 통화

}
