package com.carkoo.controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class HomepageControllerTest extends TestCase {
    private HomepageController homepageController;

    @Before
    public void setUp(){
        homepageController = new HomepageController();
        homepageController.mongoOperation = Mockito.mock(MongoOperations.class);
    }

    @Test
    public void shouldRenderHomepage(){
        assertEquals("homepage",homepageController.renderHomepage(new ModelMap()));
    }

}
