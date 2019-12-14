package com.mydata.example.example2;

import com.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample2Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample2Application.class, args);
        
        readMe();
    }

    private static void readMe() {
        //1  迅速而轻松地完成工作
        //1  Get the job done quickly and easily

        //2 看看 StudentController 演示了几个比较简单且常用的例子, 更多例子会放在后面
        //2 There are some simple examples in the StudentController, next More examples follow.
    }

}
