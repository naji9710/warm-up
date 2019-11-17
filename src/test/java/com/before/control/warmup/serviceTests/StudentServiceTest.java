package com.before.control.warmup.serviceTests;

import com.before.control.warmup.WarmUpApplication;
import com.before.control.warmup.models.Student;
import com.before.control.warmup.models.User;
import com.before.control.warmup.repositories.StudentRepository;
import com.before.control.warmup.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = WarmUpApplication.class)
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    Student student1 = new Student();
    Student student2 = new Student();

    @Test
    public void getStudentByIdTest() {


        student1.setName("Abdellah Naji");
        student1.setAge(22);
        studentRepository.save(student1);

        Student student = studentService.getStudentById(student1.getId());

        assertEquals("Abdellah Naji", student.getName(), "1111111111");
        assertEquals(22, student.getAge(), "222222");
    }

    @Test
    public void saveUserTest() {
        student1.setName("Abdellah Naji");
        student1.setAge(22);
        studentService.save(student1);

        Student student = studentService.getStudentById(student1.getId());

        assertEquals("Abdellah Naji", student.getName(), "1111111111");
        assertEquals(22, student.getAge(), "222222");
    }

    @Test
    public void GetAllUsersTest() {
        student1.setName("Abdellah Naji");
        student1.setAge(22);
        studentService.save(student1);

        student2.setName("Ghaita Haid");
        student2.setAge(55);
        studentService.save(student1);

        ArrayList<Student> students= studentService.getAllStudents();

        for (Student student : students) {
            if (student.getId() == student1.getId()) {
                assertEquals("Abdellah Naji", student.getName(), "1111111111");
                assertEquals(22, student.getAge(), "222222");
            }
            if (student.getId() == student2.getId()) {
                assertEquals("Ghaita Haid", student.getName(), "1111111111");
                assertEquals(55, student.getAge(), "222222");
            }
        }

    }
}
