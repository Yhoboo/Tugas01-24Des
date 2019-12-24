package com.yhoboo.challenge3.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordConverterServiceImpl implements PasswordConverterService{

    public static final int WORKLOAD = 12;
    @Override
    public String convertPassword(String passwordPlainText) {
        String salt = BCrypt.gensalt(WORKLOAD);
        String hashedPass = BCrypt.hashpw(passwordPlainText,salt);
        return  hashedPass;
    }
}
