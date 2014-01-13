package com.carkoo.controller;

import com.carkoo.Service.MongoCarImpl;
import com.carkoo.model.Car;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomepageController {

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String renderHomepage(ModelMap model) {
//        Car car = new Car("car2","China","info","http://www.extremetech.com/wp-content/uploads/2012/12/VWXL1-1024-640x426.jpg",28);
//        mongoOperation.save(car);
        List<Car> cars = new MongoCarImpl().findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String name = auth.getName(); //get logged in username
            model.addAttribute("username", name);
        }
        model.addAttribute("cars", cars);
		return "homepage";
	}
}