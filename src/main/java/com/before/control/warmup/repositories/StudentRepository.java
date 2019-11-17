package com.before.control.warmup.repositories;


import com.before.control.warmup.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getById(Long id);
    void deleteById(Long id);
}
