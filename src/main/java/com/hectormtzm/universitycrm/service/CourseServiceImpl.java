package com.hectormtzm.universitycrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hectormtzm.universitycrm.entity.Course;
import com.hectormtzm.universitycrm.exception.NotFoundException;
import com.hectormtzm.universitycrm.repository.CourseRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Service
public class CourseServiceImpl implements CourseService {

    final CourseRepository courseRepository;
    InstructorService instructorService;

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    
    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The course id '" + id + "' does not exist in our records"));
    }

    @Transactional
    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(long id, Course course) {
        courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The course id '" + id + "' does not exist in our records"));
        course.setId(id);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The course id '" + id + "' does not exist in our records"));
        courseRepository.deleteById(id);;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return courseRepository.findByStudentsId(studentId);
    }

    @Override
    public Course updateInstructor(long courseId, long instructorId) {
        Course course = getCourse(courseId);
        course.setInstructor(instructorService.getInstructor(instructorId));
        return courseRepository.save(course);
    }

}
