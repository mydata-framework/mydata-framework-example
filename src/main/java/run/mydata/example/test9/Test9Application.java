package run.mydata.example.test9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import run.mydata.config.MyDataAutoConfig;

@SpringBootApplication
@MyDataAutoConfig
public class Test9Application {

    public static void main(String[] args) {
        SpringApplication.run(Test9Application.class, args);
    }

}
