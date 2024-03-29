package org.ncu.studentenrollmentsystem.studentcontroller;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Instructor;
import org.ncu.studentenrollmentsystem.studentservice.InstructorService;
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
@RequestMapping("/instructorhome")
public class InstructorController
{

	@Autowired
	InstructorService instructorservice;
	
	//1. Get Request
	@GetMapping("/Instructor/getdetails")
	public List<Instructor> getInstructorDetails(){
		return instructorservice.getAllInstructor();
		}
	
	
	//2. Post Request
	@PostMapping("/Instructor/saveInstructor")
	public void saveInstructor(@RequestBody Instructor instructor){
		instructorservice.insertInstructor(instructor);
	}
	
	//3. Delete request
	@DeleteMapping("/Instructor/deleteInstructor/{id}")
	public String deleteInstructor(@PathVariable int id) {
		return instructorservice.removeOneInstructor(id);
	}
	
	//4. Update request
	@PutMapping("/Instructor/updateInstructor/")
	public String updateInstructor(@RequestParam(name="id") int id, @RequestBody Instructor updatedInstructor) {
		return instructorservice.modifyInstructor(id, updatedInstructor);
	}
}
