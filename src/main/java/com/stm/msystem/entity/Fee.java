package com.stm.msystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fee implements Serializable {
    @Id
    @Column(name = "feeId")
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "feeid_Sequence")
    @SequenceGenerator(name = "feeid_Sequence", sequenceName = "feeid_SEQ")
    Long feeID;
    @Column(name = "fees")
    Long fees;
    @Column(name = "payDate")
    String payDate;
    @Column(name = "course")
    String course;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "sid")
    Student student;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    @JsonIgnore
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Fee() {
    }

    public Fee(Long fees, String date, String course) {
        this.course = course;
        this.fees = fees;
        this.payDate = date;
    }

    public Long getFeeID() {
        return feeID;
    }

    public void setFeeID(Long feeID) {
        this.feeID = feeID;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String date) {
        this.payDate = date;
    }
}
