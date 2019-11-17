package com.before.control.warmup.services;

import com.before.control.warmup.models.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    public List<Student> allStudents();

    Student getStudentById(Long id);

    void save(Student student);

    ArrayList<Student> getAllStudents();
}
