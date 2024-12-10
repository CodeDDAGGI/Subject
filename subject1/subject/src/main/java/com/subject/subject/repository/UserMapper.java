package com.subject.subject.repository;

import com.subject.subject.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int register(User user);
    User findByEmail(String email);
    User findById(Long id);
}

