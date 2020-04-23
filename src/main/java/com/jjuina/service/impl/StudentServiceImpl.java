package com.jjuina.service.impl;

import com.jjuina.dao.StudentDao;
import com.jjuina.model.Student;
import com.jjuina.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
