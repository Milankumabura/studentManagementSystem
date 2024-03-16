package com.milan.service;

import com.milan.Student;

import java.util.List;

public interface IStudentService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void deleteStudentById(Integer id);

}
