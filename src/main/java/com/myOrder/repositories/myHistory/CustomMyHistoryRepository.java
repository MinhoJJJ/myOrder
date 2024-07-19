package com.myOrder.repositories.myHistory;

import com.myOrder.entity.Myhistory;
import java.util.List;

public interface CustomMyHistoryRepository {
    List<Myhistory> findMyHistoryById(String id);
}