package com.jjuina.controller;


import com.jjuina.model.Car;
import com.jjuina.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentDisplay");
        mav.addObject("students", studentService.getAllStudents());
        mav.addObject("testaaa", "This is from model");
        return mav;
    }
}
