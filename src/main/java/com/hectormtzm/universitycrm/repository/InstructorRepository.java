package com.hectormtzm.universitycrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitycrm.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
