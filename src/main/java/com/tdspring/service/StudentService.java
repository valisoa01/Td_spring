package com.tdspring.service;

import com.tdspring.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(List<Student> newStudentList) {
        students.addAll(newStudentList);
    }
    public List<Student> getAllStudent() {
        return students;
    }
}
