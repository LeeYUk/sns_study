package com.study.sns_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //해당 어노테이션은 jpa엔티티 클래스임을 나타냄
@Getter
@Setter
@ToString
//lombok라이브러리를 사용하여 엔티티에 구현할 getter와 setter를 자동으로 생성함
public class Post {
    @Id //jpa에서 사용하는 어노테이션으로 db의 primary key임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//db의 autoincrement를 나타냄
    private Long id;

    private String title;//게시글 제목
    private String content;//게시글 내용
    private String imagePath; //이미지 파일 경로를 저장

    @ManyToOne //db에서 사용하는 테이블간 다대일(n:1)관계를 나타냄
    @JoinColumn(name = "user_id")//foreign key를 매핑할때 사용하는 어노태이션임
    private User user;//User엔티티와 연결됨

}
