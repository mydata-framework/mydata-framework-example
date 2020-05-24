package run.mydata.example.example7.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import run.mydata.manager.ConnectionManager;
import run.mydata.manager.IConnectionManager;
import run.mydata.manager.TransManagerDefault;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "db.one")
    public DataSource oneDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "db.two")
    public DataSource twoDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public IConnectionManager oneConnectionManager() {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.setDataSource(oneDataSource());
        connectionManager.setReadDataSources(Arrays.asList(oneDataSource()));
        connectionManager.setDb("mysql");

        connectionManager.setShowSql(true);
        return connectionManager;
    }

    @Bean
    public IConnectionManager twoConnectionManager() {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.setDataSource(twoDataSource());
        connectionManager.setReadDataSources(Arrays.asList(twoDataSource()));
        connectionManager.setDb("mysql");

        connectionManager.setShowSql(true);
        return connectionManager;
    }

    @Bean
    public TransManagerDefault oneTransManagerDefault() {
        TransManagerDefault trans = new TransManagerDefault();
        trans.setConnectionManager(oneConnectionManager());
        return trans;
    }

    @Bean
    public TransManagerDefault twoTransManagerDefault() {
        TransManagerDefault trans = new TransManagerDefault();
        trans.setConnectionManager(twoConnectionManager());
        return trans;
    }

}



