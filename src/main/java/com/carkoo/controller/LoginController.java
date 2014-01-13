package com.carkoo.controller;

import com.carkoo.config.SpringMongoConfig;
import com.carkoo.controller.helper.RegisterForm;
import com.carkoo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String renderLogin(){
        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "redirect:/homepage";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("registerForm")RegisterForm registerForm, HttpServletRequest request, ModelMap model){
        User user = new User(registerForm.getUsername(), registerForm.getPassword(), 1);
        mongoOperation.save(user);

        return "redirect:/homepage";
    }

}
