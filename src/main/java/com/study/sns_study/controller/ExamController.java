package com.study.sns_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {

    @GetMapping("/")
    public String redirectLogin(){
        return "redirect:/login";
    }//어플리케이션이 처음실행되면 login 페이지로 요청

    @RequestMapping("/login")
    public String login(){
        return "login";
    } //login 페이지 요청이 들어오면 login페이지로 이동

}
