package com.wyc.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ServiceMainApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMainApp.class);
        for (Map.Entry<Object, Object> objectObjectEntry : System.getProperties().entrySet()) {
            System.out.println(objectObjectEntry.getKey()+":"+objectObjectEntry.getKey());
        }
    }

}
