package org.ncu.studentenrollmentsystem.studentdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.ncu.studentenrollmentsystem.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class InstructorDaoImpl implements InstructorDao {
	@Autowired
	  private JdbcTemplate jdbcTemplate;
	
	class InstructorRowMapper implements RowMapper < Instructor >{
		@Override
		public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Instructor instructor=new Instructor();
			instructor.setInstructorId(rs.getInt("instructorId"));
			instructor.setInstructorName(rs.getString("instructorName"));
			instructor.setInstructorSalary(rs.getInt("instructorSalary"));
			instructor.setInstructorCourse(rs.getString("intructorCourse"));
			return instructor;
		}
	}
	@Override
	public String saveInstructor(Instructor instructor) {
		int count = jdbcTemplate.update("INSERT INTO instructor(instructorId, instructorName, instructorSalary, instructorCourse) VALUES(?,?,?,?) ",
		new Object[] {instructor.getInstructorId(), instructor.getInstructorName(), instructor.getInstructorSalary(), instructor.getInstructorCourse()});
		if (count >0)
		{
			return "Saved successfully";
		} else {
			return "Error while saving!!!";
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Instructor findById(int id) {
		Optional<Instructor> t =  Optional.of(jdbcTemplate.queryForObject("SELECT * FROM instructor WHERE instructorId=?" , 
				new Object[] {
						id
				},
				new BeanPropertyRowMapper <Instructor> (Instructor.class)));
		if(t.isPresent()) {
			return t.get();
		}else {
			return new Instructor();
		}
			
	}

	@Override
	public List<Instructor> findAll() {
		return jdbcTemplate.query("select * from instructor", new InstructorRowMapper());		
	}

	@Override
	public String updateInstructor(int id, Instructor instructor) {
		int count = jdbcTemplate.update("update instructor " + "instructorName = ?, instructorSalary = ?, instructorCourse = ? " + " where instructorId = ?",
				new Object[] {
						instructor.getInstructorName(), instructor.getInstructorSalary(), instructor.getInstructorCourse(), id
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
		int count = jdbcTemplate.update("delete from Instructor where instructorId=?", new Object[] {
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
		int count = jdbcTemplate.update("DELETE from Instructor");
		if (count >0)
		{
			return "Deleted successfully";
		} else {
			return "Error while deleted!!!";
		}
	}
	

}