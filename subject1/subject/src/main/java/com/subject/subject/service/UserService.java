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
        User foundUser = userMapper.findByEmail(user.getEmail());
        if(foundUser != null){
            if(dto.getEmail().equals(foundUser.getEmail())){
                return RespSignUpDto.builder()
                        .message("중복된 이메일입니다")
                        .build();
            }
        }
        userMapper.register(user);
        return RespSignUpDto.builder()
                .user(user)
                .message("User registered successfully")
                .build();
    }

    public RespSignInDto login(ReqSignInDto dto){
        User user = userMapper.findByEmail(dto.getEmail());
        System.out.println("로그인 정보" + dto);
        System.out.println("유저 이메일 정보" + user);
        if(user == null){
            return RespSignInDto.builder()
                    .message("로그인 실패")
                    .build();
        }
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
