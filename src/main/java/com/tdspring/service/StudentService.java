package com.tdspring.service;

import com.tdspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(List<Student> newStudentList) {
        students.addAll(newStudentList);
    }
    public List<Student> getAllStudent() {
        return students;
    }
    public String getAllStudentName(List<Student> studentList) {
        return studentList.stream()
                .map(student -> student.getStudentFullName(student)).collect(Collectors.joining(", "));
    }
}
