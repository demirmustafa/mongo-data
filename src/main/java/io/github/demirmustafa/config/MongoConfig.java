package io.github.demirmustafa.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import io.github.demirmustafa.dao.BloggerDAO;
import io.github.demirmustafa.dao.BloggerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by mustafa on 4/29/17.
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = {BloggerDAO.class})
public class MongoConfig extends AbstractMongoConfiguration{


    @Override
    protected String getDatabaseName() {
        return "tutorial";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new ServerAddress("localhost",27017));
    }
}
