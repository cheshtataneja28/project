package org.ncu.studentenrollmentsystem.studentdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.ncu.studentenrollmentsystem.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CourseDaoImpl implements CourseDao {
	@Autowired
	  private JdbcTemplate jdbcTemplate;
	
	class CourseRowMapper implements RowMapper < Course >{
		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course=new Course();
			course.setCourseId(rs.getInt("courseId"));
			course.setCourseName(rs.getString("courseName"));
			course.setCredit(rs.getInt("courseCredit"));
			return course;
		}
	}
	@Override
	public String saveCourse(Course course) {
		int count = jdbcTemplate.update("INSERT INTO course(courseID, courseName, courseCredit) VALUES(?,?,?) ",
		new Object[] {course.getCourseId(), course.getCourseName(), course.getCredit()});
		if (count >0)
		{
			return "Saved successfully";
		} else {
			return "Error while saving!!!";
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course findById(int id) {
		Optional<Course> t =  Optional.of(jdbcTemplate.queryForObject("SELECT * FROM TASKS WHERE courseID=?" , 
				new Object[] {
						id
				},
				new BeanPropertyRowMapper <Course> (Course.class)));
		if(t.isPresent()) {
			return t.get();
		}else {
			return new Course();
		}
			
	}

	@Override
	public List<Course> findAll() {
		return jdbcTemplate.query("select * from course", new CourseRowMapper());		
	}

	@Override
	public String updateCourse(int id, Course course) {
		int count = jdbcTemplate.update("update course " + "coursename = ?, courseCredit = ?" + " where courseid = ?",
				new Object[] {
						course.getCourseName(), course.getCredit(), id
				});
		if (count >0)
		{
			return "Updated successfully";
		} else {
			return "Error while updating!!!";
		}
	}
	@Override
	public String deleteById(int id) {
		int count = jdbcTemplate.update("delete from course where courseid=?", new Object[] {
	            id
	        });
		if (count >0)
		{
			return "Deleted successfully";
		} else {
			return "Error while deleted!!!";
		}
	}

	@Override
	public String deleteAll() {
		int count = jdbcTemplate.update("DELETE from course");
		if (count >0)
		{
			return "Deleted successfully";
		} else {
			return "Error while deleted!!!";
		}
	}
	

}