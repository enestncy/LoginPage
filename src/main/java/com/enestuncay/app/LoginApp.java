package com.enestuncay.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.enestuncay")
public class LoginApp {

    public static void main(String[] args){

        SpringApplication.run(LoginApp.class , args);
    }
}
