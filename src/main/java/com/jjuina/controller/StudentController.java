package com.jjuina.controller;


import com.jjuina.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentDisplay");
        mav.addObject("students", studentService.getAllStudents());
        mav.addObject("testaaa", "testaaaaaaaa");
        return mav;
    }
}
