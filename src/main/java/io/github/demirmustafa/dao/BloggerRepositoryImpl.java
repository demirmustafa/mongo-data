package io.github.demirmustafa.dao;

import io.github.demirmustafa.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
public class BloggerRepositoryImpl implements BloggerDAO{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Blogger> getBloggersByBlogHostedOn(String host) {
        System.out.println("calisti");
        TypedAggregation<Blogger> aggregation = Aggregation.newAggregation(Blogger.class, Aggregation.match(Criteria.where("blogHostedOn").is(host)));
        AggregationResults<Blogger> results = mongoTemplate.aggregate(aggregation,Blogger.class);
        System.out.println(results.getMappedResults());
        return results.getMappedResults();
    }
}
