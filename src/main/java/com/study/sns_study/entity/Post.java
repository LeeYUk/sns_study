package com.study.sns_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;//게시글 제목
    private String content;//게시글 내용
    private String imagePath; //이미지 파일 경로를 저장

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
