package com.example.springbootproject.interceptor;

import com.example.springbootproject.component.EncryptComponent;
import com.example.springbootproject.component.MyToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptComponent encryptor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional.ofNullable(request.getHeader(MyToken.AUTHORIZATION))
                .map(auth -> encryptor.decryptToken(auth))
                .ifPresentOrElse(token -> {
                    request.setAttribute(MyToken.UID, token.getUid());
                    request.setAttribute(MyToken.ROLE, token.getRole());
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "您还没有登录");
                });
        return true;
    }
}