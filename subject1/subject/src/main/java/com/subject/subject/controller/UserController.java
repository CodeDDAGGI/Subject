package com.subject.subject.controller;

import com.subject.subject.dto.request.ReqSignInDto;
import com.subject.subject.dto.request.ReqSignUpDto;
import com.subject.subject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<?> register(@RequestBody ReqSignUpDto dto) {

        return ResponseEntity.ok().body(userService.register(dto));
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody ReqSignInDto dto) {

        return ResponseEntity.ok().body(userService.login(dto));
    }
}
