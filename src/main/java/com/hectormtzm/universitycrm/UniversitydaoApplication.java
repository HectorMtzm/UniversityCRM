package com.hectormtzm.universitycrm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hectormtzm.universitycrm.entity.Course;
import com.hectormtzm.universitycrm.entity.Grade;
import com.hectormtzm.universitycrm.entity.Instructor;
import com.hectormtzm.universitycrm.entity.Student;
import com.hectormtzm.universitycrm.repository.CourseRepository;
import com.hectormtzm.universitycrm.repository.InstructorRepository;
import com.hectormtzm.universitycrm.repository.ReviewRepository;
import com.hectormtzm.universitycrm.repository.StudentRepository;
import com.hectormtzm.universitycrm.service.GradeService;

@SpringBootApplication
public class UniversitydaoApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	InstructorRepository instructorRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	GradeService gradeService;	

	public static void main(String[] args) {
		SpringApplication.run(UniversitydaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Long studentId = (long) 1, courseId = (long) 1;
		Student[] students = new Student[] {
			new Student("John", "Johnson", "johnjohnson@email.com"),
			new Student("Jane", "Doe", "janedoe@email.com"),
			new Student("Bob", "Smith", "bobsmith@email.com"),
			new Student("Alice", "Smith", "alicesmith@email.com"),
			new Student("James", "Johnson", "jamesjohnson@email.com")
		};
		for (Student student : students){
			studentRepository.save(student);
		}

		Instructor[] instructors = new Instructor[] {
			new Instructor("John", "Doe", "john.doe@email.com"),
			new Instructor("Jane", "Smith", "jane.smith@email.com"),
			new Instructor("Robert", "Johnson", "robert.johnson@email.com"),
			new Instructor("Sarah", "Wilson", "sarah.wilson@email.com"),
			new Instructor("Michael", "Brown", "michael.brown@email.com"),
			new Instructor("Emily", "Jones", "emily.jones@email.com")
		};

		for (Instructor instructor : instructors) {
			instructorRepository.save(instructor);
		}

		Course[] courses = new Course[] {
			new Course("Computer Science Fundamentals", "CS101", "In this class, you will learn the foundations of computer science, including algorithms, data structures, and programming languages."),
			new Course("Object-Oriented Programming", "CS201", "In this class, you will learn the principles of object-oriented programming, including inheritance, polymorphism, and encapsulation."),
			new Course("Data Structures and Algorithms", "CS301", "In this class, you will learn about advanced data structures and algorithms, including sorting, searching, and graph theory."),
			new Course("Computer Networks", "CS401", "In this class, you will learn about the principles of computer networking, including protocols, architecture, and security."),
			new Course("Operating Systems", "CS501", "In this class, you will learn about the principles of operating systems, including process management, memory management, and file systems."),
			new Course("Computer Architecture", "CS601", "In this class, you will learn about the design and implementation of computer hardware, including processors, memory, and I/O systems.")
		};

		Arrays.stream(courses).forEach(course -> courseRepository.save(course));

		students[0].setCourses(Arrays.asList(courses[0], courses[1]));

		studentRepository.save(students[0]);

		Grade grade = new Grade();
		Grade grade2 = new Grade();
		grade.setScore("A+");
		gradeService.saveGrade(grade, studentId, courseId);
		grade2.setScore("B-");
		gradeService.saveGrade(grade2, studentId, courseId+1);
	}

}
