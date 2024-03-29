package org.ncu.studentenrollmentsystem.studentservice;

import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Course;
import org.ncu.studentenrollmentsystem.studentdao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao coursedao;
	
	@Override
	public Course getOneCourse(int id) {
		return coursedao.findById(id);
	}
	
	@Override
	public List<Course> getAllCourse() {
		return coursedao.findAll();
	}

	@Override
	public String insertCourse(Course course) {
		return coursedao.saveCourse(course);
	}

	@Override
	public String removeOneCourse(int id) {
		return coursedao.deleteById(id);
	}

	@Override
	public String removeAllCourse() {
		return coursedao.deleteAll();
	}
	
	@Override
	public String modifyCourse(int id, Course course) {
		return coursedao.updateCourse(id, course);
	}
}
