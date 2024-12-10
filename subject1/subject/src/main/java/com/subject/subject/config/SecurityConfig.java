package com.subject.subject.config;

import com.subject.subject.security.filter.JwtAccessTokenFilter;

import com.subject.subject.security.handler.AuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
        http.formLogin().disable();
        http.httpBasic().disable();
        http.csrf().disable();
        http.headers().frameOptions().disable(); // h2-console 접속 가능하게 해줌
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 시큐리티때 세션을 미사용하겠다
        http.cors();
        http.exceptionHandling().authenticationEntryPoint(authenticationHandler);

        http.authorizeRequests()
                .antMatchers(
                        "/auth/**" ,
                        "/h2-console/**",
                        "/board/**")
                .permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/board/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtAccessTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
