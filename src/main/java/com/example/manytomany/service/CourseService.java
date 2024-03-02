package com.example.manytomany.service;

import com.example.manytomany.model.Course;
import com.example.manytomany.model.Student;
import com.example.manytomany.repository.CourseRepository;
import com.example.manytomany.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    public Course add(Course course) {
       return courseRepository.save(course);
    }
}
