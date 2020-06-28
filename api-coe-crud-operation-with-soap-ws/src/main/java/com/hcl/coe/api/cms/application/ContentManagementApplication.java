package com.hcl.coe.api.cms.application;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.hcl.coe.api.cms.repository" })
@ComponentScan(value = "com.hcl.coe.api.cms.*")
@EntityScan(basePackages = { "com.hcl.coe.api.cms.entity" })
public class ContentManagementApplication { 
	
	public static void main(String[] args) {
		SpringApplication.run(ContentManagementApplication.class, args);
    }     
	
	 @Autowired
	 DataSource dataSource;
}