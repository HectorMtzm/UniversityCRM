package com.hectormtzm.universitydao.service;

import java.util.List;

import com.hectormtzm.universitydao.entity.Instructor;

public interface InstructorService {

    /**
     * Retrieves an {@link Instructor} from the database by their ID.
     * 
     * @param id The ID of the instructor to retrieve.
     * @return The instructor with the specified ID.
     * @throws NotFoundException If the instructor with the specified ID does not
     *                           exist in the database.
     */
    Instructor getInstructor(Long id);


    /**
     * Saves a new {@link Instructor} to the database.
     * 
     * @param instructor The instructor to save.
     * @return The saved instructor.
     */
    Instructor saveInstructor(Instructor instructor);


    /**
     * Updates an {@link Instructor} in the database.
     * 
     * @param id         The ID of the instructor to update.
     * @param instructor The updated instructor.
     * @return The updated instructor.
     * @throws NotFoundException If the instructor with the specified ID does not
     *                           exist in the database.
     */
    Instructor updateInstructor(long id, Instructor instructor);


    /**
     * Deletes an {@link Instructor} from the repository by their id.
     * 
     * @param id the id of the instructor to delete
     * @throws NotFoundException if the instructor id does not exist in the
     *                           repository
     */
    void deleteInstructor(Long id);


    /**
     * Retrieves a list of all {@link Instructor} from the repository.
     * 
     * @return a list of all instructors in the repository
     */
    List<Instructor> getInstructors();
}
