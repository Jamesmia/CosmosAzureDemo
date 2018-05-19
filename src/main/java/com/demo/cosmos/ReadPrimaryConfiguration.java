package com.demo.cosmos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.demo.cosmos", mongoTemplateRef = "readPrimaryTemplate")
@Import(MongoConfiguration.class)
public class ReadPrimaryConfiguration {
	@Bean
	public MongoTemplate readPrimaryTemplate(@Qualifier("readFromPrimaryMongo") Mongo mongo) throws Exception {
		final MongoDbFactory factory = new SimpleMongoDbFactory((MongoClient) mongo, "springgeo");
		return new MongoTemplate(factory);
	}
}
