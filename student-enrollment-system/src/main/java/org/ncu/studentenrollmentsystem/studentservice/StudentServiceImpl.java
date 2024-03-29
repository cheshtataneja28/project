package org.ncu.studentenrollmentsystem.studentservice;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Student;
import org.ncu.studentenrollmentsystem.studentdao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentdao;
	
	@Override
	public Student getOneStudent(int id) {
		return studentdao.findById(id);
	}
	
	@Override
	public List<Student> getAllStudent() {
		return studentdao.findAll();
	}

	@Override
	public String insertStudent(Student student) {
		return studentdao.saveStudent(student);
	}

	@Override
	public String removeOneStudent(int id) {
		return studentdao.deleteById(id);
	}

	@Override
	public String removeAllStudent() {
		return studentdao.deleteAll();
	}
	
	@Override
	public String modifyStudent(int id, Student student) {
		return studentdao.updateStudent(id, student);
	}
	@Override
    public List<Student> filterStudents(String course, int year) {
        return studentdao.filterStudents(course, year);
    }

    @Override
    public List<Student> sortStudents(String sortBy) {
        return studentdao.sortStudents(sortBy);
    }
}
