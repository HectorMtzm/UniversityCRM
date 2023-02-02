package com.hectormtzm.universitycrm.service;

import java.util.List;

import com.hectormtzm.universitycrm.entity.Course;
import com.hectormtzm.universitycrm.entity.Instructor;
import com.hectormtzm.universitycrm.entity.Student;

public interface CourseService {

    /**
     * Retrieves a {@link Course} from the database with the specified id.
     * 
     * @param id the id of the course to retrieve
     * @return the course with the specified id
     * @throws NotFoundException if a course with the given id does not exist in the
     *                           database
     */
    Course getCourse(Long id);


    /**
     * Saves a {@link Course} to the database.
     * 
     * @param course the course to save
     * @return the saved course
     */
    Course saveCourse(Course course);


    /**
     * Updates an existing {@link Course} in the database.
     * 
     * @param id     the id of the course to update
     * @param course the updated course object
     * @return the updated course object
     * @throws NotFoundException if the course id does not exist in the database
     */
    Course updateCourse(long id, Course course);


    /**
     * Deletes a {@link Course} from the database.
     * 
     * @param id the id of the course to delete
     * @throws NotFoundException if the course id does not exist in the database
     */
    void deleteCourse(Long id);


    /**
     * Retrieves a list of all {@link Course}.
     * 
     * @return list of courses.
     */
    List<Course> getCourses();


    /**
     * Retrieves a list of {@link Course} for a given {@link Student} id.
     * 
     * @param studentId the id of the student.
     * @return list of courses for the given student.
     */
    List<Course> getCoursesByStudentId(Long id);


    /**
     * Assigns an {@link Instructor} to a {@link Course}.
     * 
     * @param courseId     the id of the course to be updated.
     * @param instructorId the id of the instructor to be assigned to the course.
     * @return the updated course.
     */
    Course updateInstructor(long courseId, long instructorId);
    
}
