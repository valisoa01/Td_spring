package com.tdspring.controller;

import com.tdspring.model.Student;
import com.tdspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/welcome")
    public String getWelcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody List<Student> studentList) {
         studentService.addStudent(studentList);
         return studentService.getAllStudentName(studentService.getAllStudent());
    }
    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }


}

