package com.jade.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.jade.dao")
public class DataSourceConfig {


    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
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
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(new Resource[]{resolver.getResource("classpath:mybatis/mapper/UserMapper.xml"), resolver.getResource("classpath:mybatis/mapper/JadeMapper.xml")});
        return sqlSessionFactory.getObject();
    }
}
