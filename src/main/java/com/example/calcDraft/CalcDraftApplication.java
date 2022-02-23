package com.example.calcDraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalcDraftApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalcDraftApplication.class, args);
    }

}
