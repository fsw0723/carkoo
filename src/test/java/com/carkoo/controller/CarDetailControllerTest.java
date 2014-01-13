package com.carkoo.controller;

import com.carkoo.Service.MongoCarImpl;
import com.carkoo.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CarDetailControllerTest {
    private MockMvc mvc;
    @Autowired CarDetailController controller;
    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        controller.mongoCar = mock(MongoCarImpl.class);
    }

    @Test
    public void shouldRenderCarDetails() throws Exception {
        Mockito.when(controller.mongoCar.findById(anyString())).
                thenReturn(new Car());
        mvc.perform(get("/detail/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail"));
    }
}
