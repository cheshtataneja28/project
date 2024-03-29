package org.ncu.studentenrollmentsystem.studentservice;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Instructor;
import org.ncu.studentenrollmentsystem.studentdao.InstructorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	InstructorDao instructordao;
	
	@Override
	public Instructor getOneInstructor(int id) {
		return instructordao.findById(id);
	}
	
	@Override
	public List<Instructor> getAllInstructor() {
		return instructordao.findAll();
	}

	@Override
	public String insertInstructor(Instructor instructor) {
		return instructordao.saveInstructor(instructor);
	}

	@Override
	public String removeOneInstructor(int id) {
		return instructordao.deleteById(id);
	}

	@Override
	public String removeAllInstructor() {
		return instructordao.deleteAll();
	}
	
	@Override
	public String modifyInstructor(int id, Instructor instructor) {
		return instructordao.updateInstructor(id, instructor);
	}
}
