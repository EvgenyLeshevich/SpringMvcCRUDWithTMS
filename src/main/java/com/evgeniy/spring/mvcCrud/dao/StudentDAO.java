package com.evgeniy.spring.mvcCrud.dao;

import com.evgeniy.spring.mvcCrud.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> getStudents();

    public void saveStudent(Student student);

    public Student getStudent(int id);

    public void deleteStudent(int id);
}
