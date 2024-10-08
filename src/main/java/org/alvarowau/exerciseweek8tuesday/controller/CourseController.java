package org.alvarowau.exerciseweek8tuesday.controller;

import org.alvarowau.exerciseweek8tuesday.model.Course;
import org.alvarowau.exerciseweek8tuesday.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable("id") Long id) {
        Optional<Course> optional = repository.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Búsqueda de cursos utilizando filtros opcionales
    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "instructorName", required = false) String instructorName) {
        List<Course> courses;
        if (courseName != null && instructorName != null) {
            courses = repository.findByCourseNameContainingIgnoreCase(courseName);
            courses.retainAll(repository.findByInstructorNameContainingIgnoreCase(instructorName));
        } else if (courseName != null) {
            courses = repository.findByCourseNameContainingIgnoreCase(courseName);
        } else if (instructorName != null) {
            courses = repository.findByInstructorNameContainingIgnoreCase(instructorName);
        } else {
            courses = repository.findAll();
        }
        return ResponseEntity.ok(courses);
    }
}
