package com.nagarro.spring.flightdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.nagarro.spring.flightdemo.repository")
@ComponentScan(basePackages = "com.nagarro.spring.flightdemo.repository")
@PropertySource(value = { "classpath:application.properties" })
public class MongoConfiguration extends AbstractMongoConfiguration {

	//@Autowired
	//private Environment env;
	
    @Override
    protected String getDatabaseName() {
        return "dataBaseName";
    	//return env.getRequiredProperty("mongo.db");
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

   /* @Override
    protected String getMappingBasePackage() {
        return "net.viralpatel.spring";
    }
    public @Bean MongoDbFactory getMongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "SpringMongoDb");
	}

	public @Bean MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
		return mongoTemplate;
	}*/
}