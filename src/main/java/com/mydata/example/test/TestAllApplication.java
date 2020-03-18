package com.mydata.example.test;

import com.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestComponent;

import javax.annotation.Resource;

@SpringBootApplication
@MyDataAutoConfig
public class TestAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAllApplication.class, args);
    }

}
