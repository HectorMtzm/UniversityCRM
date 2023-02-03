package com.hectormtzm.universitycrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitycrm.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByStudentsId(Long id);
    List<Course> findByInstructorId(Long id);
}
