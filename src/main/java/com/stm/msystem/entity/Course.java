package com.stm.msystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course implements Serializable {
    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "cid_Sequence")
    @SequenceGenerator(name = "cid_Sequence", sequenceName = "CID_SEQ")
    Long courseId;
    @Column(name = "cName")
    String cName;
    @Column(name = "cDuration")
    String cDuration;
    @Column(name = "qualification")
    String qualification;


    public Course() {
    }

    public Course(String cName, String cDuration, String qualification) {
        this.cName = cName;
        this.cDuration = cDuration;
        this.qualification = qualification;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDuration() {
        return cDuration;
    }

    public void setcDuration(String cDuration) {
        this.cDuration = cDuration;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
