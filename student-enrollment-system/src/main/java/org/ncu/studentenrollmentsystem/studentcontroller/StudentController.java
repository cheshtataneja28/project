package org.ncu.studentenrollmentsystem.studentcontroller;

import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Student;
import org.ncu.studentenrollmentsystem.studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studenthome")
public class StudentController
{
	@Autowired
	StudentService studentservice;
	
	//1. Get Request
	@GetMapping("/Student/getdetails")
	public List<Student> getStudentDetails(){
		return studentservice.getAllStudent();
		}
	
	
	//2. Post Request
	@PostMapping("/Student/saveStudent")
	public void saveStudent(@RequestBody Student student){
		studentservice.insertStudent(student);
	}
	
	//3. Delete request
	@DeleteMapping("/Student/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentservice.removeOneStudent(id);
	}
	
	//4. Update request
	@PutMapping("/Student/updateStudent/")
	public String updateStudent(@RequestParam(name="id") int id, @RequestBody Student updatedStudent) {
		return studentservice.modifyStudent(id, updatedStudent);
	}

}
