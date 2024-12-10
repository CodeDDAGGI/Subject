package com.subject.subject.security.filter;

import com.subject.subject.entity.User;
import com.subject.subject.repository.UserMapper;
import com.subject.subject.security.jwt.JwtProvider;
import com.subject.subject.security.prinsipalUser.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtAccessTokenFilter extends GenericFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String bearerAccessToken = request.getHeader("Authorization");

        if(bearerAccessToken == null || bearerAccessToken.isBlank()){
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        String accessToken = jwtProvider.removeBearer(bearerAccessToken);
        Claims claims = null;

        try {
            claims = jwtProvider.getClaims(accessToken);
            Long userId = ((Integer) claims.get("userId")).longValue(); // 래퍼 클래스로 변환
            User user = userMapper.findById(userId);
            if(user == null){
                throw new JwtException("해당 ID(" + userId + ")의 사용자 정보를 찾지 못했습니다");
            }
            PrincipalUser principalUser = user.toPrincipal();
            if(!principalUser.isEnabled()){

            }
            // null 넣어도 상관없음
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, null , principalUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }   catch (JwtException e){
            e.printStackTrace();
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }



        filterChain.doFilter(servletRequest , servletResponse);
    }
}
