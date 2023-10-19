package com.mvc.springmock.dao;

import com.mvc.springmock.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scinkir
 * @since 19.10.2023
 */
@Repository
public class StudentDao implements IStudentDao {

    List<Student> studentList = new ArrayList<>();


    @Override
    public List<Student> addStudent(Student student) {
        studentList.add(student);
        return studentList;
    }
}
