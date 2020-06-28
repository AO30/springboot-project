package com.example.springbootproject.component;

import com.example.springbootproject.entity.Admin;
import com.example.springbootproject.entity.User;
import com.example.springbootproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitComponent implements InitializingBean {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        String number = "00000";
        User user = userService.getUser(number);
        if (user == null) {
            Admin admin = new Admin();
            admin.setNumber(number);
            admin.setName("AO");
            admin.setRole(User.Role.ADMIN);
            admin.setPassword(encoder.encode("00000"));
            userService.addAdmin(admin);
        }
    }
}
