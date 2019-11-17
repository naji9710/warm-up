package com.before.control.warmup.controllers;

import com.before.control.warmup.models.Student;
import com.before.control.warmup.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudentForm(@RequestParam String name, String email, int age) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);
        studentService.save(student);
        return "redirect:/home/students";
    }

}
