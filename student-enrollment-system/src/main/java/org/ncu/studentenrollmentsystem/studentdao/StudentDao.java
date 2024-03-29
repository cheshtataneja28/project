package org.ncu.studentenrollmentsystem.studentdao;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Student;


public interface StudentDao {

	public String saveStudent(Student student);
	public Student findById(int id);
	public List<Student> findAll();
	public String updateStudent(int id, Student student);
	public String deleteById(int id);
	public String deleteAll();
	List<Student> filterStudents(String course, int year); 
    List<Student> sortStudents(String sortBy);
}

