package com.stm.msystem.service;

import com.stm.msystem.entity.Fee;
import com.stm.msystem.entity.FeeRequest;
import com.stm.msystem.entity.Student;
import com.stm.msystem.repository.FeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeeService {
    private FeeRepository feeRepository;
    private StudentService studentService;
    private CourseService courseService;

    public FeeService(FeeRepository feeRepository, StudentService studentService) {
        this.feeRepository = feeRepository;
        this.studentService = studentService;
    }
    public List<Fee> getAllFees(){
        return feeRepository.findAll();
    }
    public Fee createFee(FeeRequest fee) throws Exception {
        Student student = studentService.getStudentById(fee.getSid());
        Fee feeNew = new Fee(fee.getFees(), fee.getPayDate(), fee.getCourse());
        feeNew.setStudent(student);
        feeNew = feeRepository.save(feeNew);
        List <Fee> l = student.getFees();
        l.add(feeNew);
        student.setFees(l);
        studentService.createStudent(student);
        return feeNew;
    }
}
