package org.alvarowau.exerciseweek8tuesday.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String instructorName;
    private Integer yearPublished;
}
