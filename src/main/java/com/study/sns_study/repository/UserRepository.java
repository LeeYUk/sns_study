package com.study.sns_study.repository;

import com.study.sns_study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //CRUD 연산: 저장(save), 조회(findAll, findById), 수정(save), 삭제(delete) 등의 기본적인 데이터베이스 연산을 위한 메서드를 자동으로 사용할 수 있음
    User findByUsername(String username);//기본적인 curd메소드 findBy(조회)를 사용하여 username을 조회함
}
