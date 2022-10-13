package com.stm.msystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {
    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    Long sid;
    @Column(name = "name" , nullable = false)
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "contactNumber")
    String contactNumber;
    @Column(name = "dob")
    String dob;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    List<Fee> fees;
    @JsonIgnore
    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    public Student() {
    }

    public Student(String name, String address, String contactNumber, String dob) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dob = dob;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
