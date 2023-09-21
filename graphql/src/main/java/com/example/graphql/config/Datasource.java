package com.example.graphql.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Datasource{
	@Bean
	public DataSource getDataSource() { 
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
	    dataSourceBuilder.driverClassName("org.h2.Driver");
	    dataSourceBuilder.url("jdbc:h2:mem:testdb");
	    dataSourceBuilder.username("sa"); 
	    dataSourceBuilder.password("sa"); 
	    return dataSourceBuilder.build(); 
	}
}
