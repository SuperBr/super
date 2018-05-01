package com.wyc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class WebMainApp {

    public static void main(String[] args) {
        SpringApplication.run(WebMainApp.class);
        for (Map.Entry<Object, Object> objectObjectEntry : System.getProperties().entrySet()) {
            System.out.println(objectObjectEntry.getKey()+":"+objectObjectEntry.getKey());
        }
    }
}
