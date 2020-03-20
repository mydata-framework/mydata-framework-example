package run.mydata.example.test5;

import run.mydata.config.MyDataAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyDataAutoConfig
public class TestAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAllApplication.class, args);
    }

}
