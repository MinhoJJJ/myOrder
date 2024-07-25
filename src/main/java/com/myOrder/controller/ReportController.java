package com.myOrder.controller;


import com.myOrder.entity.Myhistory;
import com.myOrder.service.Myhistory.myhistoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class ReportController {

    @Autowired
    myhistoryService myhistoryService;


    //전체내역 페이지 이동
    @RequestMapping("/getMyhistory.do")
    public List<Myhistory> getMyhistory(HttpServletRequest request) throws Exception {
        String type=request.getParameter("type");
        String id=request.getParameter("id");
        int month = Integer.parseInt(request.getParameter("month"));

        if(type.equals("expense")){
            type="E";
        }else{
            type="I";
        }
        return myhistoryService.getMyhistory(type, id, month);

    }
}
