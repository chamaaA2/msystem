package com.stm.msystem.service.impl;

import com.stm.msystem.entity.Fee;
import com.stm.msystem.entity.Student;
import com.stm.msystem.exception.ResourceNotFoundException;
import com.stm.msystem.repository.StudentRepository;
import com.stm.msystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) throws ResourceNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exits :" + id));
    }

    @Override
    public Student updateStudent(long id, Student newStudent) {
        Student student =  studentRepository.getReferenceById(id);
        student.setAddress(newStudent.getAddress());
        student.setContactNumber(newStudent.getContactNumber());
        student.setName(newStudent.getName());
        student.setDob(newStudent.getDob());
        studentRepository.save(student);
        return student;
    }

    @Override
    public Map<String,Boolean> deleteStudent(long id) {
        Map<String,Boolean> booleanMap = new HashMap<>();
        Student student =  studentRepository.getReferenceById(id);
        studentRepository.delete(student);
        booleanMap.put("deleted",true);
        return booleanMap;
    }

    @Override
    public List<Fee> getFeesFromId(long sid) throws  Exception{
        Student student =  studentRepository.findById(sid).orElseThrow(() -> new ResourceNotFoundException("Student not exits :" + sid));
        return student.getFees();
    }
}
