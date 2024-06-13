package com.myOrder.dto;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class memberDto {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String auth;                //권한

    @Getter @Setter
    private LocalDate joinDate;         // 가입일

    @Getter @Setter
    private String lang;                // 사용자 언어

    @Getter @Setter
    private LocalDate birthday;         // 생년월일

    @Getter @Setter
    private String email;

    @Getter @Setter
    private LocalDate upt_dt;           // 수정일

    @Getter @Setter
    private String currency;            // 사용자 통화

}
