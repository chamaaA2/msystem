package com.stm.msystem.controller;

import com.stm.msystem.entity.Fee;
import com.stm.msystem.entity.Student;
import com.stm.msystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/students/fee/{id}")
    public List<Fee> getStudentFees(@PathVariable long id) throws Exception {
        return studentService.getFeesFromId(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id , @RequestBody Student newStudent) throws Exception {
        return ResponseEntity.ok(studentService.updateStudent(id,newStudent));
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
