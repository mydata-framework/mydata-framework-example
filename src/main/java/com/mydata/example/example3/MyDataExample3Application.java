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
        //1  MyData支持@Version
        //1  MyData Support @Version

        //2 看看 StudentController 演示了几个比较简单且常用的例子
        //2 There are some simple examples in the StudentController
    }

}
