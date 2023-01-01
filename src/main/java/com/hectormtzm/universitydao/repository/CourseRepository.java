package com.hectormtzm.universitydao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitydao.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByStudentsId(Long id);
}
