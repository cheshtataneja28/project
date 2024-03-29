package org.ncu.studentenrollmentsystem.studentcontroller;
import java.util.List;

import org.ncu.studentenrollmentsystem.entity.Course;
import org.ncu.studentenrollmentsystem.studentservice.CourseService;
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
@RequestMapping("/coursehome")
public class CourseController 
{
	@Autowired
	CourseService courseservice;
	
	//1. Get Request
	@GetMapping("/Course/getdetails")
	public List<Course> getCourseDetails(){
		return courseservice.getAllCourse();
		}
	
	
	//2. Post Request
	@PostMapping("/Course/saveCourse")
	public void saveCourse(@RequestBody Course course){
		courseservice.insertCourse(course);
	}
	
	//3. Delete request
	@DeleteMapping("/Course/deleteCourse/{id}")
	public String deleteCourse(@PathVariable int id) {
		return courseservice.removeOneCourse(id);
	}
	
	//4. Update request
	@PutMapping("/Course/updateCourse/")
	public String updateCourse(@RequestParam(name="id") int id, @RequestBody Course updatedCourse) {
		return courseservice.modifyCourse(id, updatedCourse);
	}
}
