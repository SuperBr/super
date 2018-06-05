package com.wyc.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.wyc.service.config.bean.DataSourceBean;
import org.springframework.beans.factory.Aware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class ServiceConfig implements Aware {
    @Resource
    private  DataSourceBean dataSourceBean;
    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceBean.getDateSourceUrl());
        dataSource.setUsername(dataSourceBean.getDateSourceUserName());
        dataSource.setPassword(dataSourceBean.getDateSourcePassWd());
        return dataSource;
    }
}
