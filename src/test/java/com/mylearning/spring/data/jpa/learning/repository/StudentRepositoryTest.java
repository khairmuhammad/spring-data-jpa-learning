package com.mylearning.spring.data.jpa.learning.repository;

import com.mylearning.spring.data.jpa.learning.entity.Guardian;
import com.mylearning.spring.data.jpa.learning.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent(){
//        Student student = Student.builder()
//                .emailId("khair@gmail.com")
//                .firstName("Khair")
//                .lastName("Memon")
//                //.guardianName("Shabir")
//                //.guardianEmail("shabir@gmail.com")
//                //.guardianMobile("12345678901")
//                .build();
//        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list: "+studentList);;
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Shabir")
                .email("shabir@gmail.com")
                .mobile("12345678901").build();

        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Mughal")
                .emailId("ali@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findAllByFirstName("Khair");
        System.out.println("Student List: "+studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findAllByFirstNameContaining("Al");
        System.out.println("Student List: "+studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findAllByGuardianName("Shabir");
        System.out.println("Student List: "+studentList);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("khair@gmail.com");
        System.out.println("Student : "+student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("khair@gmail.com");
        System.out.println("Student : "+studentName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("khair@gmail.com");
        System.out.println("Student : "+student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("khair@gmail.com");
        System.out.println("Student : "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Khair Muhammad", "khair@gmail.com");
    }


}