package com.jjuina.controller;


import com.jjuina.model.Car;
import com.jjuina.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("car")
public class FtlController {

    private static List<Car> carList = new ArrayList<Car>();

    static {
        carList.add(new Car("Honda", "Civic"));
        carList.add(new Car("Toyota", "Camry"));
        carList.add(new Car("Nissan", "Altima"));
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("helloWorld");
        mav.addObject("carList", carList);
        mav.addObject("testaaa", "This is from model");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("car") Car car) {
        if (null != car && null != car.getMake() && null != car.getModel()) {
            carList.add(car);
        }
        return new ModelAndView("redirect:getAllCars");
    }
}
