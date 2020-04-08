package com.example.springbootproject.controller;

import com.example.springbootproject.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class LoginController {
    @Value("${my.teacher}")
    private String roleTeacher;
    @Value("${my.student}")
    private String roleStudent;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptComponent encrypt;

    @PostMapping("login")
    public Map login(@RequestBody User login, HttpServletResponse response) {
        User user = Optional.ofNullable(userService.getUser(login.getNumber()))
                .filter(u -> encoder.matches(login.getPassword(), u.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误"));

        MyToken token = new MyToken(user.getId(), user.getRole());
        String auth = encrypt.encryotToken(token);
        response.setHeader(MyToken.AUTHORIZATION, auth);
        String roleCode = user.getRole() == User.Role.TEACHER ? roleTeacher : roleStudent;
        return Map.of("role", roleCode);
    }
}
