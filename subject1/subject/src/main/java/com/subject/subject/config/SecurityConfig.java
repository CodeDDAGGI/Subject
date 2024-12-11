package com.subject.subject.config;

import com.subject.subject.security.filter.JwtAccessTokenFilter;

import com.subject.subject.security.handler.AuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAccessTokenFilter jwtAccessTokenFilter;

    @Autowired
    private AuthenticationHandler authenticationHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().disable();  // 기본 로그인 페이지 비활성화
        http.httpBasic().disable();  // HTTP Basic 인증 비활성화
        http.csrf().disable();  // CSRF 비활성화
        http.headers().frameOptions().disable();  // H2 콘솔에 iframe을 허용
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // 세션 비사용
        http.cors();
        http.exceptionHandling().authenticationEntryPoint(authenticationHandler);

        http.authorizeRequests()
                .antMatchers("/auth/**", "/h2-console/**")  // H2 콘솔에 대한 접근 허용
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterBefore(jwtAccessTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
