package com.example.springbootproject.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Configuration
public class EncryptComponent {
    @Autowired
    private ObjectMapper objectMapper;
    @Value("R28K42ZEJ8LWRHUS")
    private String secretKey;
    @Value("636eac2534bcfcb0")
    private String salt;
    @Autowired
    private TextEncryptor textEncryptor;

    @Bean
    public TextEncryptor getEncryptor() {
        return Encryptors.text(secretKey, salt);
    }

    public String encryptToken (MyToken token) {
        try{
            String json = objectMapper.writeValueAsString(token);
            return textEncryptor.encrypt(json);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "服务器端错误");
        }
    }

    public MyToken decryptToken(String auth){
        try{
            String json = textEncryptor.decrypt(auth);
            return objectMapper.readValue(json,MyToken.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "无权限");
        }
    }
}
