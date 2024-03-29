package org.ncu.studentenrollmentsystem.entity;
import org.springframework.stereotype.Component;

@Component
public class Course 
{
	private String courseName;
	private int courseId;
	private int courseCredit;
	//constructor
	public Course()
	{
		super();
	}
	//Parameterized constructor
	public Course(String courseName, int courseId, int credit) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseCredit = credit;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCredit() {
		return courseCredit;
	}
	public void setCredit(int credit) {
		this.courseCredit = credit;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", credit=" + courseCredit + "]";
	}
	
	
	}
