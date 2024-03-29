package org.ncu.studentenrollmentsystem.studentservice;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Student;

public interface StudentService {
	public Student getOneStudent(int id);
	public String insertStudent(Student student);
	public String removeOneStudent(int id);
	public String modifyStudent(int id,Student student);
	public List<Student> getAllStudent();
	public String removeAllStudent();
	List<Student> filterStudents(String course, int year); // New method for filtering
    List<Student> sortStudents(String sortBy);
}
