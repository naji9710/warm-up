package com.before.control.warmup.controllers;

import com.before.control.warmup.models.Student;
import com.before.control.warmup.models.User;
import com.before.control.warmup.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String allStudents(Model model, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        if (user == null){
            return "login";
        }
        else if(user.getRole().equals("ADMIn")) {
            model.addAttribute("students", studentService.getAllStudents());
            return "studentsPlus";
        }

        model.addAttribute("students", studentService.getAllStudents());
        return "students";

    }

    @GetMapping("/addStudent")
    public String addStudent(HttpSession httpSession,Model model) {
        User user= (User) httpSession.getAttribute("user");
        if (user == null){
            return "login";
        }
        else if(user.getRole().equals("ADMIn")) {
            model.addAttribute("students", studentService.getAllStudents());
            return "addStudent";
        }

        model.addAttribute("students", studentService.getAllStudents());
        return "redirect:/home";
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

    @GetMapping("/students/{studentId}")
    public String oneStudent(@PathVariable("studentId") Long studentId, Model model ) {
        Student student=studentService.getStudentById(studentId);
        model.addAttribute(student);
        return "showStudent";
    }
    @GetMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId ) {
        studentService.deleteStudent(studentId);
        return "redirect:/home/students";
    }
}
