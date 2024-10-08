package org.alvarowau.exerciseweek8tuesday.util;

import org.alvarowau.exerciseweek8tuesday.model.Course;
import org.alvarowau.exerciseweek8tuesday.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) {
        // Verifica si la base de datos ya tiene cursos para evitar duplicados
        if (courseRepository.count() == 0) {
            IntStream.range(1, 16).forEach(i -> {
                Course course = Course.builder()
                        .courseName("Course" + i)
                        .instructorName("Instructor" + i)
                        .yearPublished(2023)
                        .build();
                courseRepository.save(course);
            });
        }
    }
}