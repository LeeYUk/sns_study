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

        String user  = session.getAttribute("username").toString();
        System.out.println(user);
        if(user != null){
            //로그인한 사용자에게 보여줄 정보를 모델에 추가
//            model.addAttribute("username",user);
            return "main";
        }
        else {
            return "redirect:/login";
        }

    }

}
