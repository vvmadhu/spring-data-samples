package com.hcl.coe.api.cms.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.hcl.coe.api.cms.repository")
public class ContentConfig {

	@Value("${mongodb.url}")
	private String mongodbUrl;

	@Value("${mongo.Dbname}")
	private String mongoDBName;

	@Value("${mongo.DbName.collection}")
	private String mongoCollection;
	
	@Value("${mongo.connection.perhost}")
	private int mongoConnectioPerHost;
	
	@Value("${mongo.connection.multiplier}")
	private int mongoConnectionMultiplier;

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, CustomConversions mongoConverter) throws Exception {
		MongoTemplate template = new MongoTemplate(mongoDbFactory);
		MappingMongoConverter mappingMongoConverter = (MappingMongoConverter)template.getConverter();
		mappingMongoConverter.setCustomConversions(mongoConverter);
		return template;
	}
	
	@Bean(name = "mongoDbFactory")
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClient mongo = new MongoClient(mongodbUrl);
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, mongoDBName);
		return mongoDbFactory;
	}
	
	@Bean(name="mongoConverter")
	public CustomConversions mongoConverter() {
		return new CustomConversions(Collections.emptyList());
	}              

	
}