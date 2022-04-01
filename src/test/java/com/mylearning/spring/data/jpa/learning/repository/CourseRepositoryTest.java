package com.mylearning.spring.data.jpa.learning.repository;

import com.mylearning.spring.data.jpa.learning.entity.Course;
import com.mylearning.spring.data.jpa.learning.entity.Student;
import com.mylearning.spring.data.jpa.learning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Course List = "+courses);
    }

    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher = Teacher.builder()
                .firstName("Kainat")
                .lastName("Ashraf")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPagewithTwoRecords = PageRequest.of(1, 2);

        long totalElements = courseRepository.findAll(secondPagewithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPagewithTwoRecords).getTotalPages();

        List<Course> courseList = courseRepository.findAll(secondPagewithTwoRecords).getContent();
        System.out.println("CourseList: "+courseList);
        System.out.println("Total Elements: "+totalElements);
        System.out.println("Total Pages: "+totalPages);
    }

    @Test
    public void findAllWithSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courseList = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses Sort by title: "+courseList);
    }

    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageWithTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageWithTenRecords).getContent();
        System.out.println("findByTitleContaining: "+courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Mohammad")
                .lastName("Akram")
                .build();

        Student student = Student.builder()
                .firstName("Maisam")
                .lastName("Raza")
                .emailId("maisam@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .teacher(teacher)
                .credit(12)
                .build();
        course.addStudents(student);

        courseRepository.save(course);

    }

}