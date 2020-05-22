package run.mydata.example.example5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import run.mydata.config.MyDataAutoConfig;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample5Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample5Application.class, args);
        
        readMe();
    }

    private static void readMe() {
        //1 自动获取db name , 可自定义指定, 当配置指定db name时不再自动获取
    }

}
