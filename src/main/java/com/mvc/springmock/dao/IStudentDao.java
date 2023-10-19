package com.mvc.springmock.dao;

import com.mvc.springmock.domain.Student;

import java.util.List;

/**
 * @author scinkir
 * @since 19.10.2023
 */
public interface IStudentDao {
    List<Student> addStudent(Student student);
}
