package org.ncu.studentenrollmentsystem.studentservice;

import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Course;

public interface CourseService {
	public Course getOneCourse(int id);
	public String insertCourse(Course course);
	public String removeOneCourse(int id);
	public String modifyCourse(int id,Course course);
	public List<Course> getAllCourse();
	public String removeAllCourse();
	
}
