package run.mydata.example.example6.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import run.mydata.manager.ConnectionManager;
import run.mydata.manager.IConnectionManager;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DbConfig implements ApplicationContextAware {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "db.master")
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "db.slave1")
    public DataSource dataSourceSlave1() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ConnectionManager connectionManager = (ConnectionManager) applicationContext.getBean(IConnectionManager.class);

        DataSource dataSourceSlave1 = (DataSource) applicationContext.getBean("dataSourceSlave1");
        connectionManager.setReadDataSources(Arrays.asList(dataSourceSlave1));
    }

}
