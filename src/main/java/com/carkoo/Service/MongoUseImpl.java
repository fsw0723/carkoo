package com.carkoo.Service;


import com.carkoo.config.SpringMongoConfig;
import com.carkoo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MongoUseImpl {
    private Query query;
    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    public User findByUsername(String username){
        query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        List<User> user = mongoOperation.find(query, com.carkoo.model.User.class);
        return user.get(0);
    }
}
