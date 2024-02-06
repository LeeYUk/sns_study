package com.study.sns_study.controller;

import com.study.sns_study.entity.Post;
import com.study.sns_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @Autowired
    private PostService postService;


    @GetMapping("/posts") //posts 요청이 들어온다면
    public ResponseEntity<List<Post>> getAllPosts(){ //데이터베이스에 저장된 게시글을 json형식으로 전송하는 메소드
        List<Post> posts=postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
}
