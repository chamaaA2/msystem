package com.stm.msystem.service;

import com.stm.msystem.entity.Course;
import com.stm.msystem.exception.ResourceNotFoundException;
import com.stm.msystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourses(){
     return courseRepository.findAll();
    }
    public Course createCourse(Course course){
     return courseRepository.save(course);
    }

    public Course getCourseById(long id) throws Exception{
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not fount :"+id));
    }

    public Course updateCourse(long id, Course course) throws Exception{
        Course courseNew = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not fount :"+id));
        courseNew.setcDuration(course.getcDuration());
        courseNew.setcName(course.getcName());
        courseNew.setQualification(course.getQualification());
        courseRepository.save(courseNew);
        return courseNew;
    }

    public Map<String,Boolean> deleteCourse(long id) throws Exception {
        Course courseDel = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not fount :"+id));
        courseRepository.delete(courseDel);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",true);
        return map;
    }
}
