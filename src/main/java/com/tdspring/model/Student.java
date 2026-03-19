package com.tdspring.model;

import lombok.Data;

@Data
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private int age;

    public String getStudentFullName(Student student) {
        return student.getFirstName() + " " + student.getLastName();
    }
}
