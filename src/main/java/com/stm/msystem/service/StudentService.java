package com.stm.msystem.service;

import com.stm.msystem.entity.Fee;
import com.stm.msystem.entity.Student;
import com.stm.msystem.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);

    Student getStudentById(long id) throws ResourceNotFoundException;

    Student updateStudent(long id, Student student);

    Map<String,Boolean> deleteStudent(long id);

    List<Fee> getFeesFromId(long sid) throws  Exception;
}
