package com.hectormtzm.universitydao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hectormtzm.universitydao.entity.Student;
import com.hectormtzm.universitydao.exception.NotFoundException;
import com.hectormtzm.universitydao.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    CourseService courseService;

    // Fix Circular dependency
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The student id '" + id + "' does not exist in our records"));
    }
    
    @Transactional
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student updateStudent(Long id, Student student) {
        studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The student id '" + id + "' does not exist in our records"));
        student.setId(id);
        return studentRepository.save(student);
    }
    
    @Transactional
    @Override
    public void deleteStudent(Long id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The student id '" + id + "' does not exist in our records"));
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getStudents(int pageNumber, int pageSize, Sort.Direction direction, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, direction, sortBy);
        return studentRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Student addCourseToStudent(long studentId, long courseId) {
        Student student = getStudent(studentId);
        student.getCourses().add(courseService.getCourse(courseId));
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public void removeCourseFromStudent(Long studentId, Long courseId) {
        Student student = getStudent(studentId);
        if(!getStudent(studentId).getCourses().remove(courseService.getCourse(courseId)))
            throw new NotFoundException("Student with id '" + studentId + "' is not enrolled it course with id " + courseId);
        studentRepository.save(student);
    }
    
}
