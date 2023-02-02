package com.hectormtzm.universitycrm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitycrm.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByCourseId(Long courseId);
    
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}
