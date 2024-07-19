package com.myOrder.repositories.myHistory;

import com.myOrder.entity.Myhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyHistoryRepository extends JpaRepository<Myhistory, String>, CustomMyHistoryRepository {
    // 기본 CRUD 메서드는 JpaRepository에서 제공됩니다.
}