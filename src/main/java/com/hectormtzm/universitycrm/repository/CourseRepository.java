package com.hectormtzm.universitycrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hectormtzm.universitycrm.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByStudentsId(Long id);  
    
    List<Course> findByInstructorId(Long id);

    @Query("FROM Course c WHERE c.instructor.id = :instructorId")
    List<Course> getInstructorCourses(@Param("instructorId") Long id);


    /*
    private final EntityManager entityManager;

    public default List<Course> findCoursesByInstructorId(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Course> query = session.createQuery("FROM Course c WHERE c.instructor.id = :instructorId", Course.class);
        query.setParameter("instructorId", id);
        return query.getResultList();
    }
    */
}
