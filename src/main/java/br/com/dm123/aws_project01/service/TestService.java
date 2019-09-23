package br.com.dm123.aws_project01.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public boolean isUserMatilde(String name) {
        return "matilde".equals(name);
    }

}
