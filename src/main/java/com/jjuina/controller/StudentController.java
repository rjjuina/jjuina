package com.jjuina.controller;


import com.jjuina.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentDisplay");
        mav.addObject("students", studentService.getAllStudents());
        mav.addObject("testaaa", "This is from model");
        return mav;
    }
}
