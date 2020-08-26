package com.deltadental.coe.api.cms.application;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories( basePackages = { "com.deltadental.coe.api.cms.mysql.repository" }, entityManagerFactoryRef = "mySqlEntityManagerFactory", 
transactionManagerRef = "mySqlTransactionManager")
@EntityScan(basePackages = { "com.deltadental.coe.api.cms.mysql.entity" })
public class MySqlConfig {
     
	
	@Value("${mysql.datasource.url}")
	String databaseUrl;
	
	@Value("${mysql.datasource.username}")
	String databaseUser;
	
	@Value("${mysql.datasource.password}")
	String databasePassword;
	
	@Value("${mysql.datasource.driver.class}")
	String databaseDriver;

	@Value("${mysql.hibernate.dialect}")
	String mySqldialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	String hbm2ddlAuto;
	
	@Primary
    @Bean
    public DataSource mySqlDataSource() {  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePassword);
 
        return dataSource;
    }
	
	@Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mySqlDataSource());
        em.setPackagesToScan( new String[] { "com.deltadental.coe.api.cms.mysql.entity" } );
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.put("hibernate.dialect", mySqldialect);
        em.setJpaPropertyMap(properties);
 
        return em;
    }
	
 
	@Primary
    @Bean
    public PlatformTransactionManager mySqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mySqlEntityManagerFactory().getObject());
        return transactionManager;
    }

}
