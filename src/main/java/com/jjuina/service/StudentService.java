package com.jjuina.service;

import com.jjuina.dao.StudentDao;
import com.jjuina.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
