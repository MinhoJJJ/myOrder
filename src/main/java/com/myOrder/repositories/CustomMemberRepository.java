package com.myOrder.repositories;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;

public interface CustomMemberRepository {
    Member findByUserId(memberDto memberDto);
    Member findByUserPw(memberDto memberDto);
    int insertMember(memberDto memberDto);
}
