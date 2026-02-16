package com.example.formapi.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.formapi.model.Student;
import com.example.formapi.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")


public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping("/add")
    public Student create(@RequestBody Student student) {
        System.out.println(student.getName());
        System.out.println(student.getEmail());
        System.out.println(student.getCourse());
        return repository.save(student);
    }

    // READ ALL
    @GetMapping("/list")
    public List<Student> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());

        return repository.save(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }

}
