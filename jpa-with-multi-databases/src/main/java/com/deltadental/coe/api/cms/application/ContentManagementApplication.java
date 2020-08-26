package com.deltadental.coe.api.cms.application;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(value = "com.deltadental.coe.api.cms.*")
@EnableJpaRepositories(basePackages = { "com.deltadental.coe.api.cms.repository" })
@EntityScan(basePackages = { "com.deltadental.coe.api.cms.entity" })
@SpringBootApplication
public class ContentManagementApplication {

    Logger logger = LoggerFactory.getLogger(ContentManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ContentManagementApplication.class, args);
    }    
  	
    
	@Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.deltadental.coe.api.cms.controller"))
                .build();
    }
	
/*
	@Value("${datasource.driver-class-name}")
	private String datasourceDriverClass;
	
	@Value("${datasource.url}")
	private String datasourceUrl;

	@Value("${datasource.username}")
	private String datasourceUsername;

	@Value("${datasource.password}")
	private String datasourcePassword;
	
	@Bean(destroyMethod = "close")
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(datasourceDriverClass);
        dataSourceConfig.setJdbcUrl(datasourceUrl);
        dataSourceConfig.setUsername(datasourceUsername);
        dataSourceConfig.setPassword(datasourcePassword);
 
        return new HikariDataSource(dataSourceConfig);
    }
*/

}