package com.study.sns_study.controller;
import com.study.sns_study.entity.User;
import com.study.sns_study.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    //사용자등록,회원가입
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){ //회원가입을 처리하는 메소드.
        userService.registerUser(user); // User객체를 userService를 통해 데이터베이스에 저장
        return "등록 성공!";
    }

    //로그인
    @PostMapping("/login")
    public String loginUser(@RequestParam(name="username") String username, @RequestParam(name="password") String password, HttpSession session){
        //로그인을 처리하는 메소드 , username와 password를 매개변수로 받아 userService의 validateUser 메소드를 호출 사용자 검증을 함
        System.out.println(username);
        System.out.println(password);

        User user = userService.validateUser(username,password);

        if(user!=null){
            //로그인 성공 : 사용자 정보를 세션에 저장
            session.setAttribute("username",user.getUsername());//로그인 성공시 세션에 username을 저장
            return "redirect:/main";
        }
        else {
            //로그인 실패시 로그인페이지으로 이동
            return "login";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logoutUser(HttpSession session){ //로그아웃을 처리하는 메소드
        session.invalidate();//현제 세션을 무효시킴

        return "redirect:/login";//로그아웃시 로그인페이지로 이동
    }
}

