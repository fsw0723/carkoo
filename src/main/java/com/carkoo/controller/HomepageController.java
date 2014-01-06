package com.carkoo.controller;

import com.carkoo.config.SpringMongoConfig;
import com.carkoo.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomepageController {

    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	@RequestMapping(value="/homepage", method = RequestMethod.GET)
	public String renderHomepage(ModelMap model) {
//        Car car = new Car("car2","China","info","http://www.extremetech.com/wp-content/uploads/2012/12/VWXL1-1024-640x426.jpg",28);
//        mongoOperation.save(car);
        List<Car> cars = mongoOperation.findAll(Car.class);
        model.addAttribute("cars", cars);
		return "homepage";
	}
}