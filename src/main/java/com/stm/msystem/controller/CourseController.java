package com.stm.msystem.controller;

import com.stm.msystem.entity.Course;
import com.stm.msystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> listCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> crateCourse(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable long id , @RequestBody Course course) throws Exception {
        return ResponseEntity.ok(courseService.updateCourse(id,course));
    }

    @PostMapping("/courses")
    public Course saveStudent(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }
}
