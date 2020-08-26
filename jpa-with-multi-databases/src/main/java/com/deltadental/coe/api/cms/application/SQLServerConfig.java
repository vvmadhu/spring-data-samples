package com.deltadental.coe.api.cms.application;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
@EnableJpaRepositories( basePackages = { "com.deltadental.coe.api.cms.sqlserver.repository"} , entityManagerFactoryRef = "sqlServerEntityManagerFactory", 
transactionManagerRef = "sqlServerTransactionManager")
@EntityScan(basePackages = { "com.deltadental.coe.api.cms.sqlserver.entity" })
public class SQLServerConfig {
	
	@Value("${sqlserver.datasource.url}")
	String databaseUrl;
	
	@Value("${sqlserver.datasource.username}")
	String databaseUser;
	
	@Value("${sqlserver.datasource.password}")
	String databasePassword;
	
	@Value("${sqlserver.datasource.driver.class}")
	String databaseDriver;
	
	@Value("${sqlserver.hibernate.dialect}")
	String sqlServerdialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	String hbm2ddlAuto;
	
    @Bean
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePassword);
 
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sqlServerDataSource());
        em.setPackagesToScan( new String[] { "com.deltadental.coe.api.cms.sqlserver.entity" } );
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.put("hibernate.dialect", sqlServerdialect);
        em.setJpaPropertyMap(properties);
 
        return em;
    }	
 
    @Bean
    public PlatformTransactionManager sqlServerTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sqlServerEntityManagerFactory().getObject());
        return transactionManager;
    }
}
