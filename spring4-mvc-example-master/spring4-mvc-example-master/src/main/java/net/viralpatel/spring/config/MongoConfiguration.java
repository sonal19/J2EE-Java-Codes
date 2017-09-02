package net.viralpatel.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="net.viralpatel.spring.repo")
@ComponentScan(basePackages = "net.viralpatel.spring.repo")
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "dataBaseName";
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