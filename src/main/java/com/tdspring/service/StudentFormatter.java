package com.tdspring.service;

import com.tdspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFormatter {
    public String getAllStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getStudentFullName)
                .collect(Collectors.joining(", "));
    }
}
