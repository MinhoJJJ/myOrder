package com.myOrder.repositories.member;

import com.myOrder.entity.Member;
import com.myOrder.repositories.member.CustomMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
}
