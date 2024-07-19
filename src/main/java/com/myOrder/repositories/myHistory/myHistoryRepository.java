package com.myOrder.repositories.myHistory;

import com.myOrder.entity.MyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface myHistoryRepository extends JpaRepository<MyHistory, Long>, CustomMyHistoryRepository {
}
