package com.hectormtzm.universitycrm.service;

import java.util.List;

import com.hectormtzm.universitycrm.entity.Grade;
import com.hectormtzm.universitycrm.entity.Student;

public interface GradeService {

    /**
     * Retrieves a {@link Grade} for a {@link Student} in a particular course.
     * 
     * @param studentId the id of the student
     * @param courseId  the id of the course
     * @return the grade for the student in the course
     * @throws NotFoundException if the grade with the specified student id and
     *                           course id does not exist in the records
     */
    Grade getGrade(Long studentId, Long courseId);


    /**
     * This method is used to save a new {@link Grade} to the database.
     * 
     * @param grade     the grade to be saved
     * @param studentId the id of the student for which the grade is to be saved
     * @param courseId  the id of the course for which the grade is to be saved
     * @return the grade object that has been saved to the database
     * @throws IllegalArgumentException if a grade for the same student and course
     *                                  already exists in the database
     */
    Grade saveGrade(Grade grade, Long studentId, Long courseId);


    /**
     * Updates the score of a {@link Grade} for a {@link Student} in a particular
     * {@link Course}.
     * 
     * @param score     the new score for the grade
     * @param studentId the id of the student
     * @param courseId  the id of the course
     * @return the updated grade
     * @throws NotFoundException if the grade with the specified student id and
     *                           course id does not exist in the records
     */
    Grade updateGrade(String score, Long studentId, Long courseId);


    /**
     * Deletes a {@link Grade} for a {@link Student} in a specific {@link Course} from the
     * database.
     * 
     * @param studentId the id of the student
     * @param courseId  the id of the course
     */
    void deleteGrade(Long studentId, Long courseId);


    /**
     * Retrieves a list of {@link Grade} for a specific {@link Student}.
     * 
     * @param studentId the id of the student whose grades are being retrieved
     * @return a list of grades for the specified student
     */
    List<Grade> getStudentGrades(Long studentId);


    /**
     * Retrieves a list of all {@link Grade} for the {@link Course} with the given
     * courseId.
     * 
     * @param courseId The id of the course for which to retrieve grades.
     * @return A list of all grades for the course with the given courseId.
     * @throws NotFoundException if no course with the given courseId exists in the
     *                           database.
     */
    List<Grade> getCourseGrades(Long courseId);


    /**
     * Retrieves a list of all {@link Grade} in the system.
     * 
     * @return a list of all grades
     */
    List<Grade> getAllGrades();
}
