package com.hectormtzm.universitydao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitydao.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
