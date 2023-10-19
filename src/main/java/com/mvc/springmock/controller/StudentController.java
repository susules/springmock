package com.mvc.springmock.controller;

import com.mvc.springmock.dao.IStudentDao;
import com.mvc.springmock.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scinkir
 * @since 19.10.2023
 */

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    IStudentDao studentDao;

    List<Student> studentList = new ArrayList<>();

    @PostMapping(path = "/addStudent", consumes = "application/json", produces = "application/json")
    public List<Student> addStudent(@RequestBody Student student) {

        List<Student> studentList = studentDao.addStudent(student);
        return studentList;
    }
}
