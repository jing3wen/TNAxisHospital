package com.example.axiswebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AxisWebClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(AxisWebClientApplication.class, args);
        System.out.println("Project is on server："+"http://localhost:8090/");
    }

}
