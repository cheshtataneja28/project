package org.ncu.studentenrollmentsystem.studentdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.ncu.studentenrollmentsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao {
	@Autowired
	  private JdbcTemplate jdbcTemplate;
	
	class StudentRowMapper implements RowMapper < Student >{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentDOB(rs.getString("studentDOB"));
			student.setStudentCourse(rs.getString("studentCourse"));
			return student;
		}
	}
	@Override
	public String saveStudent(Student student) {
		int count = jdbcTemplate.update("INSERT INTO student(studentId, studentNAME, studentDOB, studentCourse) VALUES(?,?,?,?) ",
		new Object[] {student.getStudentId(), student.getStudentName(), student.getStudentDOB(), student.getStudentCourse()});
		if (count >0)
		{
			return "Saved successfully";
		} else {
			return "Error while saving!!!";
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student findById(int id) {
		Optional<Student> t =  Optional.of(jdbcTemplate.queryForObject("SELECT * FROM student WHERE studentId=?" , 
				new Object[] {
						id
				},
				new BeanPropertyRowMapper <Student> (Student.class)));
		if(t.isPresent()) {
			return t.get();
		}else {
			return new Student();
		}
			
	}

	@Override
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());		
	}

	@Override
	public String updateStudent(int id, Student student) {
		int count = jdbcTemplate.update("update student " + "studentName = ?, studentDOB = ?, studentCourse = ? " + " where studentId = ?",
				new Object[] {
						student.getStudentName(), student.getStudentDOB(), student.getStudentCourse(), id
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
		int count = jdbcTemplate.update("delete from student where id=?", new Object[] {
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
		int count = jdbcTemplate.update("DELETE from student");
		if (count >0)
		{
			return "Deleted successfully";
		} else {
			return "Error while deleted!!!";
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	    public List<Student> filterStudents(String course, int year) {
	        String sql = "SELECT * FROM student WHERE studentCourse = ? AND studentYear = ?";
	        return jdbcTemplate.query(sql, new Object[]{course, year}, new BeanPropertyRowMapper<>(Student.class));
	    }

	    @SuppressWarnings("deprecation")
		@Override
	    public List<Student> sortStudents(String sortBy) {
	        String sql = "SELECT * FROM student ORDER BY ?";
	        return jdbcTemplate.query(sql, new Object[]{sortBy}, new BeanPropertyRowMapper<>(Student.class));
	    }
}