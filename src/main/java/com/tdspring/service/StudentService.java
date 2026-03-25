package com.tdspring.service;

import com.tdspring.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    public void addStudent(List<Student> newStudentList) {
        if (newStudentList == null || newStudentList.isEmpty()) {
            throw new IllegalArgumentException("La liste des étudiants ne peut pas être vide");
        }
        students.addAll(newStudentList);
    }

    /**
     * Retourne tous les étudiants
     */
    public List<Student> getAllStudent() {
        return new ArrayList<>(students);
    }
}