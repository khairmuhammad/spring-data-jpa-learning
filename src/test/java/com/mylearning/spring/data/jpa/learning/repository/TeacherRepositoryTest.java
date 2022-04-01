package com.mylearning.spring.data.jpa.learning.repository;

import com.mylearning.spring.data.jpa.learning.entity.Course;
import com.mylearning.spring.data.jpa.learning.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course course = Course.builder()
                .title("DBA")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Hassan")
                .lastName("Khan")
                //.courses(List.of(course))
        .build();

        teacherRepository.save(teacher);
    }

}