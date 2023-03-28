package com.hectormtzm.universitycrm.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hectormtzm.universitycrm.entity.Course;
import com.hectormtzm.universitycrm.entity.Grade;
import com.hectormtzm.universitycrm.entity.Student;
import com.hectormtzm.universitycrm.exception.BadRequestException;
import com.hectormtzm.universitycrm.exception.NotFoundException;
import com.hectormtzm.universitycrm.repository.GradeRepository;

import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    StudentService studentService;
    CourseService courseService;

    // Fix Circular dependency
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    // Fix Circular dependency
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new NotFoundException("The grade with student id: '" + studentId
                        + "' and course id: '" + courseId + "' does not exist in our records"));
    }

    @Transactional
    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        if (gradeRepository.findByStudentIdAndCourseId(studentId, courseId).isPresent())
            throw new BadRequestException("The grade for student id: '" + studentId
                    + "' and course id: '" + courseId + "' already exists");

        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new NotFoundException("The grade with student id: " + studentId
                        + " and course id: '" + courseId + "' does not exist in our records"));
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        studentService.getStudent(studentId);
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        courseService.getCourse(courseId);
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
