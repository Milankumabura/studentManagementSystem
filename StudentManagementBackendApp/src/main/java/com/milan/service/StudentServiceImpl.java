package com.milan.service;

import com.milan.Student;
import com.milan.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  IStudentService {

    @Autowired
    private StudentRepo repo;
    @Override
    public Student saveStudent(Student student)
    {
        repo.save(student);
        return null;
    }

    @Override
    public List<Student> getAllStudents()
    {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = repo.findById(id);
        return optional.get();
    }

    @Override
    public void deleteStudentById(Integer id)
    {
        repo.deleteById(id);
    }
}
