package com.jade.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setDriverClassName(driver);
        ((DruidDataSource) dataSource).setUrl(url);
        ((DruidDataSource) dataSource).setUsername(username);
        ((DruidDataSource) dataSource).setPassword(password);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

}
