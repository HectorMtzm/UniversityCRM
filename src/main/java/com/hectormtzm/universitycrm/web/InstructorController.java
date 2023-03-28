package com.hectormtzm.universitycrm.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hectormtzm.universitycrm.entity.Instructor;
import com.hectormtzm.universitycrm.service.InstructorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> geInstructor(@PathVariable Long id) {
        return new ResponseEntity<>(instructorService.getInstructor(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instructor> saveInstructor(@Valid @RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.saveInstructor(instructor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @Valid @RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.updateInstructor(id, instructor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
