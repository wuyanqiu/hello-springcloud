package com.qsh.springbootcruddemo.entities;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Department department;

    private Integer deptId;
    private Date birth;
    private String password;
    private String verification;

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Integer deptId, Date birth, String password, String verification) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.deptId = deptId;
        this.birth = birth;
        this.password = password;
        this.verification = verification;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", deptId=" + deptId +
                ", birth=" + birth +
                ", password='" + password + '\'' +
                ", verification='" + verification + '\'' +
                '}';
    }
}
