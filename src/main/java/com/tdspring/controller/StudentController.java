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
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> studentList) {
        try {
            studentService.addStudent(studentList);
            return  ResponseEntity
                    .status(201)
                    .body(studentService.getAllStudent());
        } catch (Exception e){
            return ResponseEntity
                    .status(500)
                    .build();
        }
    }
    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

}

