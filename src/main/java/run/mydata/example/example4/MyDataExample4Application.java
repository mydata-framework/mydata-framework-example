package run.mydata.example.example4;

import run.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample4Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample4Application.class, args);
        
        readMe();
    }

    private static void readMe() {
        //1 简化Param OrderBy 代码长度
    }

}
