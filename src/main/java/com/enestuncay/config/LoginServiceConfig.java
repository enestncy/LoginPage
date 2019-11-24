package com.enestuncay.config;

import com.enestuncay.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginServiceConfig {

    @Bean
    public LoginService loginService(){
        LoginService loginService = new LoginService();
        return loginService;
    }
}
