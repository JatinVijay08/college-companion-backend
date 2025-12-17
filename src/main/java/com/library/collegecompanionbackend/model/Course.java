package com.library.collegecompanionbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String courseCode;
    @Column(nullable = false)
    private String courseDescription;

    @ManyToOne
    @JoinColumn(name="teacher_id",nullable = false)
    private User teacher;

}
