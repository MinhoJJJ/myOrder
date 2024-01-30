package com.myOrder.repositories;

import com.myOrder.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);

}
