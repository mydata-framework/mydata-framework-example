package run.mydata.example.example7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MyDataAutoConfig
public class MyDataExample7Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample7Application.class, args);
        readMe();
    }

    private static void readMe() {
        //多数据源配置 , more data source
    }

}
