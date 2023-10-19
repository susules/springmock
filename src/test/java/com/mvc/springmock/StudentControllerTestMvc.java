package com.mvc.springmock;

import com.mvc.springmock.controller.StudentController;
import com.mvc.springmock.dao.StudentDao;
import com.mvc.springmock.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author scinkir
 * @since 19.10.2023
 */

@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTestMvc {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentDao studentDao;

    @Test
    public void TestAddStudent() throws Exception {

        Student studentAyse = new Student();
        studentAyse.setName("ayse");
        studentAyse.setSurname("ay");

        List<Student> list = new ArrayList<>();
        list.addAll(Arrays.asList(studentAyse));

        when(studentDao.addStudent(any(Student.class))).thenReturn(list);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .post("/student/addStudent", studentAyse)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"ayse\"}"))
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(
                "[{\"name\":\"ayse\",\"surname\":\"ay\"}]"
        );


    }


}
