package com.spring.orm.dao;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public void insert(Student student) {
        this.hibernateTemplate.save(student);
    }

    @Override
    public Student getStudent(int studentId) {
        return this.hibernateTemplate.get(Student.class, studentId);
    }

    public Student getStudentByName(String studentName) {
        return this.hibernateTemplate.get(Student.class, studentName);
    }

    @Override
    public List<Student> getAll() {
        return this.hibernateTemplate.loadAll(Student.class);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = getStudent(studentId);
        this.hibernateTemplate.delete(student);
    }

    @Override
    @Transactional
    public void updateStudent(int studentId) {
        Student student = getStudent(studentId);
        student.setStudentName("Ahmad");
    }
}
