package com.gaena.restpreview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gaena.restpreview.dao")
public class RestPreviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestPreviewApplication.class, args);
    }

}
