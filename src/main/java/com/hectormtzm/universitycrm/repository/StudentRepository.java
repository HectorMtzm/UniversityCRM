package com.hectormtzm.universitycrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitycrm.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
