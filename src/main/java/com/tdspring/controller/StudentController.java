package com.tdspring.controller;

import com.tdspring.model.Student;
import com.tdspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/welcome")
     public ResponseEntity<String> getAllStudents(@RequestParam(required = false) String name ) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity
                    .status(400)
                    .body("Parameter 'name' is missing");
        }
        return ResponseEntity
                .status(200)
                .body("Welcome" + name);
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

