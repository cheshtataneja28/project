package org.ncu.studentenrollmentsystem.studentdao;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Course;



public interface CourseDao {
	
	public String saveCourse(Course course);
	public Course findById(int id);
	public List<Course> findAll();
	public String updateCourse(int id,Course course);
	public String deleteById(int id);
	public String deleteAll();

	
}
