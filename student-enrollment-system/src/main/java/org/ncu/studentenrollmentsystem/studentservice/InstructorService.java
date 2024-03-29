package org.ncu.studentenrollmentsystem.studentservice;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Instructor;

public interface InstructorService {
	public Instructor getOneInstructor(int id);
	public String insertInstructor(Instructor instructor);
	public String removeOneInstructor(int id);
	public String modifyInstructor(int id,Instructor instructor);
	public List<Instructor> getAllInstructor();
	public String removeAllInstructor();
	
}
