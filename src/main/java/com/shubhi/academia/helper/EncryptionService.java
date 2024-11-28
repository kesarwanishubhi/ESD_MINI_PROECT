package com.shubhi.academia.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EncryptionService {
    private final PasswordEncoder passwordEncoder;
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validates(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
