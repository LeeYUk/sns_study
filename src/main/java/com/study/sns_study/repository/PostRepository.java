package com.study.sns_study.repository;

import com.study.sns_study.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    //Post엔티티에 대한 인터페이스를 정의함 jpa리포지토리를 상속받음으로써 기본적인 CRUD메소드를 제공함
}
