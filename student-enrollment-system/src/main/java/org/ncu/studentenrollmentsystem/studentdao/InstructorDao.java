package org.ncu.studentenrollmentsystem.studentdao;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Instructor;

public interface InstructorDao 
{

	public String saveInstructor(Instructor Instructor);
	public Instructor findById(int id);
	public List<Instructor> findAll();
	public String updateInstructor(int id,Instructor Instructor);
	public String deleteById(int id);
	public String deleteAll();


}
