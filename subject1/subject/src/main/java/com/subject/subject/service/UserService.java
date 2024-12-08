package com.subject.subject.service;

import com.subject.subject.dto.request.ReqSignInDto;
import com.subject.subject.dto.request.ReqSignUpDto;
import com.subject.subject.dto.response.RespSignInDto;
import com.subject.subject.dto.response.RespSignUpDto;
import com.subject.subject.entity.User;
import com.subject.subject.repository.UserMapper;
import com.subject.subject.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RespSignUpDto register(ReqSignUpDto dto) {
        User user = null;

        user = dto.toEntity(passwordEncoder);

        userMapper.register(user);
        return RespSignUpDto.builder()
                .user(user)
                .message("User registered successfully")
                .build();
    }

    public RespSignInDto login(ReqSignInDto dto){
        User user = userMapper.findByEmail(dto.getEmail());
        if(user.getEmail().equals(dto.getEmail())&& passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            return RespSignInDto.builder()
                    .expireDate(jwtProvider.getExpireDate().toString())
                    .accessToken(jwtProvider.generateAccessToken(user))
                    .token("jwt-token")
                    .message("success")
                    .build();
        }else{
            return RespSignInDto.builder()
                    .message("fail")
                    .build();
        }
    }
}
