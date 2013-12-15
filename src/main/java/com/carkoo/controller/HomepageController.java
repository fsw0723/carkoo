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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomepageController {

    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {

        List<Car> cars = mongoOperation.findAll(Car.class);
        model.addAttribute("cars", cars);
		model.addAttribute("message", "Hello world!");
		return new ModelAndView("homepage", model);
	}
}