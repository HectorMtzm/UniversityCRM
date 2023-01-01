package com.hectormtzm.universitydao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitydao.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
