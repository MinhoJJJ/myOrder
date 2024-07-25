package com.myOrder.service.Myhistory;


import com.myOrder.entity.Myhistory;
import com.myOrder.repositories.category.CategoryRepository;
import com.myOrder.repositories.myHistory.MyHistoryRepository;
import com.myOrder.service.Setting.settingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class myhistoryServiceImpl implements myhistoryService {

    @Autowired
    MyHistoryRepository myhistoryRepository;

    public List<Myhistory> getMyhistory(String type, String id,int month) throws Exception {
        return myhistoryRepository.findMyHistoryByIdAndType(type,id, month);
    }

}

