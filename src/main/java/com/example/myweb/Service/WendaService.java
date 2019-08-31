package com.example.myweb.Service;

import org.springframework.stereotype.Service;

@Service
public class WendaService {
    public String getMessage(int userId) {
        return "message" + String.valueOf(userId);
    }
}
