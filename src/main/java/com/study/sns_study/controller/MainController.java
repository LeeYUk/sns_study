package com.study.sns_study.controller;

import com.study.sns_study.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model) {

        String user  = session.getAttribute("username").toString(); //세션에서  username값을 가져와 문자열로 반환함 로그인시 세션에 저장된 사용자이름표기
        System.out.println(user);
        if(user != null){ //username이 세션에 있다면

            return "main"; //메인페이지로 반환
        }
        else {
            return "redirect:/login";//로그인 하지않은 상태라면 로그인페이지로 리다이렉트
        }

    }

}
