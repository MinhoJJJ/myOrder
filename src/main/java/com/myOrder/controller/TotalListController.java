package com.myOrder.controller;

import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import com.myOrder.repositories.myHistory.MyHistoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Slf4j
public class TotalListController {

    @Autowired
    MyHistoryRepository myHistoryRepository;

    /**
     * 전체내역 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/totalListData.do")
    public List<Myhistory> totalListData(String id) {
        List<Myhistory> myHistory;
        Member member= new Member();
        member.setId(id);
        myHistory=myHistoryRepository.findMyHistoryById(member);
        return myHistory;
    }
}
