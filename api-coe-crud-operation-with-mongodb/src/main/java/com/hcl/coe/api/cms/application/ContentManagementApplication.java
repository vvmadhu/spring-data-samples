package com.hcl.coe.api.cms.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(value = "com.hcl.coe.api.cms.*")
@EnableSwagger2
public class ContentManagementApplication {

    Logger logger = LoggerFactory.getLogger(ContentManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ContentManagementApplication.class, args);
    }    
  	
	@Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hcl.coe.api.cms.controller"))
                .build();
    }

}