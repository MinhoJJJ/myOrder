package com.myOrder.repositories.myHistory;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Member;
import com.myOrder.entity.MyHistory;

public interface CustomMyHistoryRepository {
    MyHistory findMyHistory(memberDto memberDto);

}
