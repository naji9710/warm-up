package com.before.control.warmup.services.serviceImpl;

import com.before.control.warmup.models.Student;
import com.before.control.warmup.repositories.StudentRepository;
import com.before.control.warmup.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ArrayList<Student> allStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }
}
