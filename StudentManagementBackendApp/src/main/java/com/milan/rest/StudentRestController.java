package com.milan.rest;

import com.milan.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.milan.Student;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentRestController {

    @Autowired
    private IStudentService service;

    @PostMapping("/Student")
    public Student registerStudent(@RequestBody Student student)
    {
        System.out.println("Student data: " + student);
        Student st = service.saveStudent(student);
        return st;
    }

    @GetMapping("/Students")
    public List<Student> getAllStudents()
    {
        List<Student> list = service.getAllStudents();
        return list;
    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
    {
        Student stu = service.getStudentById(id);
        //return ResponseEntity.ok(stu);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    @DeleteMapping("/Student/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Integer id)
    {
        //return new ResponseEntity<>(new Student(), HttpStatus.OK);
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
