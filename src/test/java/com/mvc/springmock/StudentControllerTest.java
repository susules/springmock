package com.mvc.springmock;

import com.mvc.springmock.controller.StudentController;
import com.mvc.springmock.dao.StudentDao;
import com.mvc.springmock.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author scinkir
 * @since 19.10.2023
 */
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;
    @Mock
    StudentDao studentDao;


    @Test
    public void TestAddStudent(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Student studentAyse = new Student();
        studentAyse.setName("ayse");
        studentAyse.setSurname("ay");

        List<Student> list = new ArrayList<>();
        list.addAll(Arrays.asList(studentAyse));

        when(studentDao.addStudent(any(Student.class))).thenReturn(list);
        List<Student> gelenList = studentController.addStudent(studentAyse);
        assertThat(gelenList.size()).isEqualTo(1);

        Student studentElif = new Student();
        studentAyse.setName("elif");
        studentAyse.setSurname("ay");
        list.add(studentElif);

        when(studentDao.addStudent(any(Student.class))).thenReturn(list);
        gelenList = studentController.addStudent(studentElif);
        assertThat(gelenList.size()).isEqualTo(2);



    }
}
