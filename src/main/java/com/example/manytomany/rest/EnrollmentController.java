package com.example.manytomany.rest;

import com.example.manytomany.model.Course;
import com.example.manytomany.model.Student;
import com.example.manytomany.service.CourseService;
import com.example.manytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/createStudent")
    public ResponseEntity<Student> enrollStudentInCourse(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/createCourse")
    public ResponseEntity<Course> enrollStudentInCourse(@RequestBody Course course) {
        courseService.add(course);
        return ResponseEntity.ok(course);
    }
    @PostMapping("/enroll/student/{studentId}/course/{courseId}")
    public ResponseEntity<Student> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/add/student/{studentId}/course/{courseId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Course course = courseService.addStudentToCourse(studentId, courseId);
        return ResponseEntity.ok(course);
    }
}
