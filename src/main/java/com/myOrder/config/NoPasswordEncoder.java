package com.myOrder.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
public class NoPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {  // 입력 받은 비밀번호를 그대로 문자열로 반환하여 별도의 암호화를 수행하지 않습니다. 즉, 비밀번호를 암호화하지 않고 그대로 반환합니다.
        return rawPassword.toString();
    }
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {   //입력 된 비밀번호와 암호화된 비밀번호가 일치하는지를 그대로 비교합니다. 하지만 여기서는 따로 암호화가 안되어있어 그냥 비교만 함
        return rawPassword.toString().equals(encodedPassword);
    }
}