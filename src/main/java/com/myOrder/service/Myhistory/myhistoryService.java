package com.myOrder.service.Myhistory;

import com.myOrder.dto.memberDto;
import com.myOrder.entity.Myhistory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public interface myhistoryService {
    public List<Myhistory> getMyhistory(String type, String id,int month) throws Exception;
}
