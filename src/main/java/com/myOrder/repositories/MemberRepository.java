package com.myOrder.repositories;

import com.myOrder.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository{
    Member findByUserId2(String userId);
}
