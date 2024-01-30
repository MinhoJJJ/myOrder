package com.myOrder.repositories;

import com.myOrder.entity.Member;

public interface CustomMemberRepository {
    Member findByUserId2(String userId);
}
