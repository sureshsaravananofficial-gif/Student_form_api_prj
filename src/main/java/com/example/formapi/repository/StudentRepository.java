package com.example.formapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.formapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
