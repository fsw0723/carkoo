package com.carkoo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CarDetailControllerTest {
    private MockMvc mvc;
    @Autowired private CarDetailController controller;
    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        controller.mongoOperation = Mockito.mock(MongoOperations.class);
    }

    @Test
    public void shouldRenderCarDetails() throws Exception {
//        Mockito.when(controller.mongoOperation.findOne(any(Query.class), Matchers.<Class<Object>>any())).
//                thenReturn(new Car());
//        mvc.perform(get("/detail/123"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("detail"));
    }
}
