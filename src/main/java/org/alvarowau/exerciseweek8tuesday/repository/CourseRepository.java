package org.alvarowau.exerciseweek8tuesday.repository;

import org.alvarowau.exerciseweek8tuesday.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
    List<Course> findByInstructorNameContainingIgnoreCase(String instructorName);
    List<Course> findByYearPublished(Integer yearPublished);
}
