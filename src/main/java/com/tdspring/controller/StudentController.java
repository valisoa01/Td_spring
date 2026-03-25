package com.tdspring.controller;

import com.tdspring.model.Student;
import com.tdspring.service.StudentFormatter;
import com.tdspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentFormatter studentFormatter;

    @GetMapping("/welcome")
     public ResponseEntity<String> welcome(@RequestParam String name ) {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome " + name);
    }
    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> studentList) {
         return  ResponseEntity.status(201).body(studentService.getAllStudent());
    }
    @GetMapping("/students")
    public ResponseEntity<?> getAllStudent(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        List<Student> studentList = studentService.getAllStudent();
        if (acceptHeader == null || acceptHeader.isBlank()) {
            throw  new NotAcceptableException("Accept header is missing");
        }
        if(acceptHeader.contains("application/json")) {
            return ResponseEntity.ok(studentList);
        }
        if (acceptHeader.contains("text/plain")) {
            String result = studentFormatter.getAllStudentNames(studentList);
            return ResponseEntity.ok(result);
        }
        throw  new NotAcceptableException("Accept header is missing");
    }

}

