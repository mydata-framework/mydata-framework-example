package run.mydata.example.example6;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import run.mydata.config.MyDataAutoConfig;
import run.mydata.config.MyDataProperties;
import run.mydata.manager.ConnectionManager;
import run.mydata.manager.IConnectionManager;
import run.mydata.manager.TransManager;
import run.mydata.manager.TransManagerDefault;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@MyDataAutoConfig
public class MyDataExample6Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDataExample6Application.class, args);
        readMe();
    }

    private static void readMe() {
        //主从配置 , master and slave1 config example
    }

}
