package com.myOrder.repositories.myHistory;

import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import java.util.List;

public interface CustomMyHistoryRepository {
    List<Myhistory> findMyHistoryById(Member member);
}