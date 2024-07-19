package com.myOrder.controller;

import com.myOrder.entity.Member;
import com.myOrder.entity.MyHistory;
import com.myOrder.repositories.myHistory.myHistoryRepository;
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
    myHistoryRepository myHistoryRepository;

    /**
     * 전체내역 페이지 이동
     * @return ModelAndView
     * @throws Exception
     * @author 정민호
     * @since 2024. 06. 13.
     */
    @RequestMapping("/totalListData.do")
    public List<MyHistory> totalListData(String id) {
        List<MyHistory> myHistory;
        Member member= new Member();
        member.setId(id);
        myHistory=myHistoryRepository.findMyHistory(member);
        return myHistory;
    }
}
