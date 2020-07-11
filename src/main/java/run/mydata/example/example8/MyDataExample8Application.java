package run.mydata.example.example8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import run.mydata.config.MyDataAutoConfig;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample8Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample8Application.class, args);
        readMe();
    }

    private static void readMe() {
        //Short Byte 字段测试
    }

}
