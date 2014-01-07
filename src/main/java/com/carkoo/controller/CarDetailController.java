package com.carkoo.controller;

import com.carkoo.config.SpringMongoConfig;
import com.carkoo.model.Car;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarDetailController {
    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @RequestMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable("id") String id, ModelMap model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));
        Car car = mongoOperation.findOne(query, Car.class);
        model.addAttribute("car", car);
        return "detail";
    }
}
