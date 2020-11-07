package run.mydata.example.version10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import run.mydata.config.MyDataAutoConfig;

@SpringBootApplication
@MyDataAutoConfig
public class Version10Application {

    public static void main(String[] args) {
        SpringApplication.run(Version10Application.class, args);
    }

}
