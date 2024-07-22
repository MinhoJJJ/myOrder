package com.myOrder.controller;


import com.myOrder.entity.Member;
import com.myOrder.entity.Myhistory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Slf4j
public class SettingController {

    //전체내역 페이지 이동
//    @RequestMapping("/insertCategoryName.do")
//    public List<Myhistory> insertCategoryName(String gubun,String id) {
////        List<Myhistory> myHistory;
////        Member member= new Member();
////        member.setId(id);
////        //myHistory=myHistoryRepository.findMyHistoryById(member);
////        return myHistory;
//    }
    public int checkNowCategory(String gubun,String id){
        return 0;
    }

}
