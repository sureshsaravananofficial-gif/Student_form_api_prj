package com.example.formapi.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.formapi.model.Student;
import com.example.formapi.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
