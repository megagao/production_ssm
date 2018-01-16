package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Size;

public class Employee {
	@Size(max=40, message="{id.length.error}")
	private String empId;
	
	@Size(max=40, message="员工姓名过长！")
    private String empName;

	@Size(max=2, message="员工性别过长！")
    private String sex;

	@Size(min=18, max=18, message="请输入正确身份证号！")
    private String idCode;

    private Date birthday;

    private Date joinDate;

    private String status;

    @Size(max=20, message="学历的长度限制在20个字符之内！")
    private String education;

    @Size(max=20, message="学位的长度限制在20个字符之内！")
    private String degree;

    @Size(max=20, message="专业的长度限制在20个字符之内！")
    private String major;

    @Size(max=40, message="毕业院校的长度限制在40个字符之内！")
    private String graduateSchool;

    @Size(max=40, message="受教育形式的长度限制在40个字符之内！")
    private String educationForm;

    private String departmentId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool == null ? null : graduateSchool.trim();
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm == null ? null : educationForm.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }
}