package com.example.manytomany.repository;

import com.example.manytomany.model.Course;
import com.example.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
