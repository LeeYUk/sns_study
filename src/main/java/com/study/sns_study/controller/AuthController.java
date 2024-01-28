package com.study.sns_study.controller;
import com.study.sns_study.entity.User;
import com.study.sns_study.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
//@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    //사용자등록,회원가입
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "등록 성공!";
    }

    //로그인
    @PostMapping("/login")
    public String loginUser(@RequestParam(name="username") String username, @RequestParam(name="password") String password, HttpSession session){
        System.out.println(username);
        System.out.println(password);

        User user = userService.validateUser(username,password);

        if(user!=null){
            //로그인 성공 : 사용자 정보를 세션에 저장
            session.setAttribute("username",user.getUsername());
            return "redirect:/main";
        }
        else {
            //로그인 실패시 로그인창으로 이동
            return "login";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();

        return "redirect:/login";
    }
}

