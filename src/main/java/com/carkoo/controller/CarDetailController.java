package com.carkoo.controller;

import com.carkoo.Service.MongoCarImpl;
import com.carkoo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarDetailController {
    public MongoCarImpl mongoCar;
    public CarDetailController(){
        mongoCar = new MongoCarImpl();
    }

    @RequestMapping(value = "/detail/{id}")
    public String viewDetail(@PathVariable("id") String id, ModelMap model) {
        Car car = mongoCar.findById(id);
        model.addAttribute("car", car);
        return "detail";
    }
}
