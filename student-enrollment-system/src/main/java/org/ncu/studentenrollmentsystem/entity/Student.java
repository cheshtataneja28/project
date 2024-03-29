package org.ncu.studentenrollmentsystem.entity;

import org.springframework.stereotype.Component;

@Component

public class Student
{
	private String studentName;
	private int studentId;
	private String studentCourse;
	private String studentDOB;
	//constructor
	public Student()
	{
		super();
	}
	//Parameterized constructor
	public Student(String studentName, int studentId, String studentCourse, String studentDOB) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentCourse = studentCourse;
		this.studentDOB = studentDOB;
	}
	//gettersetters
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	public String getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}
	//tostring

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", studentCourse=" + studentCourse
				+ ", studentDOB=" + studentDOB + "]";
	}
	
	
	
	

}