package org.ncu.studentenrollmentsystem.entity;
import org.springframework.stereotype.Component;

@Component

public class Instructor 
{
	private String instructorName;
	private int instructorId;
	private String instructorCourse;
	private double instructorSalary;

	//constructor
	public Instructor()
	{
		super();
	}
	//Parameterized constructor

	public Instructor(String instructorName, int instructorId, String instructorCourse, double instructorSalary) {
		super();
		this.instructorName = instructorName;
		this.instructorId = instructorId;
		this.instructorCourse = instructorCourse;
		this.instructorSalary = instructorSalary;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorCourse() {
		return instructorCourse;
	}

	public void setInstructorCourse(String instructorCourse) {
		this.instructorCourse = instructorCourse;
	}

	public double getInstructorSalary() {
		return instructorSalary;
	}

	public void setInstructorSalary(double instructorSalary) {
		this.instructorSalary = instructorSalary;
	}

	@Override
	public String toString() {
		return "Instructor [instructorName=" + instructorName + ", instructorId=" + instructorId + ", instructorCourse="
				+ instructorCourse + ", instructorSalary=" + instructorSalary + "]";
	}
	
	
	
	
}
