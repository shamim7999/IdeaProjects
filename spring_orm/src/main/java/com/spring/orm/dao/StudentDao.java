package com.spring.orm.dao;

import com.spring.orm.entities.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student student);

    public List<Student> getAll();

    public Student getStudent(int studentId);

    public void deleteStudent(int studentId);

    public void updateStudent(int studentId);

    public Student getStudentByName(String studentName);
}
