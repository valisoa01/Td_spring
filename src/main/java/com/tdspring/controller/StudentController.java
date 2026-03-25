package com.tdspring.controller;

import com.tdspring.exception.BadRequestException;
import com.tdspring.exception.NotAcceptableException;
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
    public ResponseEntity<String> welcome(@RequestParam String name) {
        if (name == null || name.isBlank()) {
            throw new BadRequestException("Le paramètre 'name' est obligatoire");
        }
        return ResponseEntity.ok("Welcome " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> studentList) {
        studentService.addStudent(studentList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentList);
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudent(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {

        List<Student> students = studentService.getAllStudent();

        if (acceptHeader == null || acceptHeader.isBlank()) {
            throw new BadRequestException("Accept header is missing");
        }

        if (acceptHeader.contains("application/json")) {
            return ResponseEntity.ok(students);
        }

        if (acceptHeader.contains("text/plain")) {
            String result = studentFormatter.getAllStudentNames(students);
            return ResponseEntity.ok(result);
        }

        throw new NotAcceptableException("Format not supported: " + acceptHeader);
    }
}