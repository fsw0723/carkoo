package com.carkoo.controller;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class HomepageControllerTest extends TestCase {
    private HomepageController homepageController;
//
//    @Before
//    public void setUp(){
//        homepageController = new HomepageController();
//        homepageController.carRepository = Mockito.mock(CarRepository.class);
//    }
//
//    @Test
//    public void shouldRenderHomepage(){
//        List<Car> cars = new ArrayList<Car>();
//        cars.add(new Car());
//        when(homepageController.carRepository.findAll()).thenReturn(cars);
//        ModelMap modelMap = homepageController.printWelcome(new ModelMap());
//        assertEquals(modelMap.get("cars"),cars);
//    }

}
