package com.hectormtzm.universitycrm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hectormtzm.universitycrm.service.validation.Score;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade", uniqueConstraints = { 
    @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Score
    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonIgnore
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "course_id")
    private Course course;

}
