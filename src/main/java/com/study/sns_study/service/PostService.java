package com.study.sns_study.service;

import com.study.sns_study.entity.Post;
import com.study.sns_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void createPost(Post post){
        //게시글 저장 로직
        postRepository.save(post);
    }
}
