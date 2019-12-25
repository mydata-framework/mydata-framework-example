package com.mydata.example.example3;

import com.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample3Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample3Application.class, args);
        
        readMe();
    }

    private static void readMe() {
    }

}
