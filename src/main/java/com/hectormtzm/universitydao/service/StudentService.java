package com.hectormtzm.universitydao.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.hectormtzm.universitydao.entity.Student;

public interface StudentService {

    /**
     * Retrieves a {@link Student} based on the provided id.
     * 
     * @param id the id of the student to retrieve
     * @return the {@link Student} object corresponding to the provided id
     * @throws NotFoundException if the student with the specified id does not
     *                           exist in the database.
     */
    Student getStudent(Long id);


    /**
     * Saves a {@link Student} to the database.
     * 
     * @param student the student to save
     * @return the saved student 
     */
    Student saveStudent(Student student);


    /**
     * Updates a {@link Student} in the database.
     * 
     * @param id the id of the student to update
     * @param student the updated student 
     * @return the updated student 
     * @throws NotFoundException if the student with the specified id does not
     *                           exist in the database.
     */
    Student updateStudent(Long id, Student student);


    /**
     * Deletes a {@link Student} from the database.
     * 
     * @param id the id of the student to delete
     * @throws NotFoundException if no student with the given id exists in the
     *                           database
     */
    void deleteStudent(Long id);
    
    
    /**
     * Retrieves all {@link Student} from the database.
     * 
     * @return a list of all students in the database
     */
    List<Student> getStudents();


    /**
     * Retrieves a page of {@link Student} from the database.
     * 
     * @param pageNumber the number of the page to retrieve
     * @param pageSize   the number of students per page
     * @param direction  the sort direction (ascending or descending)
     * @param sortBy     the property to sort by
     * @return a page of students
     */
    Page<Student> getStudents(int pageNumber, int pageSize, Sort.Direction direction, String sortBy); 
    
    
    /**
     * Add a {@link Course} to a {@link Student}.
     * 
     * @param studentId the id of the student to add the course to
     * @param courseId  the id of the course to add to the student
     * @return the updated student object
     * @throws NotFoundException if the student or course does not exist
     */
    Student addCourseToStudent(long studentId, long courseId);


    /**
     * Remove a {@link Course} from a {@link Student}.
     * 
     * @param studentId the id of the student to remove the course from
     * @param courseId  the id of the course to remove from the student
     * @throws NotFoundException if the student or course does not exist, or if the
     *                           student is not enrolled in the course
     */
    void removeCourseFromStudent(Long studentId, Long courseId);
}
