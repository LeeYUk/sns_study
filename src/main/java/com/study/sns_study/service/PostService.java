package com.study.sns_study.service;

import com.study.sns_study.entity.Post;
import com.study.sns_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void createPost(Post post){ //작성한 게시글을 데이터베이스에 저장하는 메소드
        //게시글 저장
        postRepository.save(post);
    }

    public List<Post> getAllPosts(){ //작성된 게시글을 모두 가져오는 메소드
        //모든게시글 조회
        return postRepository.findAll();
    }
}
