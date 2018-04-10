package com.jjuina.controller;


import com.jjuina.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("car")
public class CarController {

    public static Logger log = LoggerFactory.getLogger(CarController.class);

    private static List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Honda", "Civic"));
        carList.add(new Car("Toyota", "Camry"));
        carList.add(new Car("Nissan", "Altima"));
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("carDisplay");
        mav.addObject("carList", carList);
        log.info(carList.toString());
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
