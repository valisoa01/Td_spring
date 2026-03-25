package com.tdspring.service;

import com.tdspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFormatter {


    public String getAllStudentNames(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return "";
        }

        return students.stream()
                .map(Student::getFullName)
                .collect(Collectors.joining(", "));
    }
}