package com.example.config;



import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.dao.AccountDao;
import com.example.dao.LocationDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.dao.impl.LocationDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.example")
@Configuration
@EnableTransactionManagement
public class TxConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean
    public DataSource jdbcTemplate(){
        Properties properties = new Properties();
        properties.setProperty("driverClassName",driverClassName);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);
        DataSource dataSource=null;
        try {
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public AccountDao accountDao(DataSource dataSource){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        accountDao.setDataSource(dataSource);
        return accountDao;
    }
    @Bean
    public LocationDao locationDao(DataSource dataSource){
        LocationDaoImpl locationDao = new LocationDaoImpl();
        locationDao.setDataSource(dataSource);
        return locationDao;
    }

}
