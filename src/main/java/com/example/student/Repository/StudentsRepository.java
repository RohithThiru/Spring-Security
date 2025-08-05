package com.example.student.Repository;

import com.example.student.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepository extends JpaRepository<Students, Integer> {
    Students findByname(String username);
}
