package com.mydata.example.example1;

import com.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample1Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample1Application.class, args);
        
        readMe();
    }

    private static void readMe() {
        //1 mydata 就是为了敏捷开发,所以推荐你使用Springboot
        //1 mydata is a framework for agile development, so I recommend spring-boot.


        //2 在启动类上使用@MyDataAutoConfig标识后,你就可以开始你的快速开发之旅
        //2 How to quick start, The @MyDataAutoConfig are on the Application.


        //3 执行结束后,你的实体会与数据库中的表建立映射关系,这意味这你并不需要手动建表,你可以更加关注你的业务实体,并不需要过多关系表的关系
        //3 After the application starts, the domain entity mapping table is auto; You don't need to focus too much on tables;
    }

}
