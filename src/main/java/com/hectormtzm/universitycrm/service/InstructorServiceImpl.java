package com.hectormtzm.universitycrm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hectormtzm.universitycrm.entity.Instructor;
import com.hectormtzm.universitycrm.exception.NotFoundException;
import com.hectormtzm.universitycrm.repository.InstructorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService{

    InstructorRepository instructorRepository;

    @Override
    public Instructor getInstructor(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The instructor id '" + id + "' does not exist in our records"));
    }

    @Transactional
    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    
    @Transactional
    @Override
    public Instructor updateInstructor(long id, Instructor instructor) {
        instructorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The instructor id '" + id + "' does not exist in our records"));
        instructor.setId(id);
        return instructorRepository.save(instructor);
    }

    @Transactional
    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The instructor id '" + id + "' does not exist in our records"));
        instructorRepository.deleteById(id);      
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

}
