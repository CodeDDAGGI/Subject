package com.subject.subject.security.filter;

import com.subject.subject.repository.UserMapper;
import com.subject.subject.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

@Component
public class JwtAccessTokenFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public void doFilter(ServletRequest servletRequest)
}
