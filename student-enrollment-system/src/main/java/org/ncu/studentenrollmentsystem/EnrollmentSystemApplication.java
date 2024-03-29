package org.ncu.studentenrollmentsystem;

import org.ncu.studentenrollmentsystem.studentdao.CourseDao;
import org.ncu.studentenrollmentsystem.studentdao.CourseDaoImpl;
import org.ncu.studentenrollmentsystem.studentdao.InstructorDao;
import org.ncu.studentenrollmentsystem.studentdao.InstructorDaoImpl;
import org.ncu.studentenrollmentsystem.studentdao.StudentDao;
import org.ncu.studentenrollmentsystem.studentdao.StudentDaoImpl;
import org.ncu.studentenrollmentsystem.studentservice.CourseService;
import org.ncu.studentenrollmentsystem.studentservice.CourseServiceImpl;
import org.ncu.studentenrollmentsystem.studentservice.InstructorService;
import org.ncu.studentenrollmentsystem.studentservice.InstructorServiceImpl;
import org.ncu.studentenrollmentsystem.studentservice.StudentService;
import org.ncu.studentenrollmentsystem.studentservice.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class EnrollmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentSystemApplication.class, args);
	}
	@Bean 
    StudentService studentservice() {
        return new StudentServiceImpl();
    }
	
	@Bean
	StudentDao studentdao() {
        return new StudentDaoImpl();
    }
	@Bean
    CourseService courseservice() {
        return new CourseServiceImpl();
    }
	
	@Bean
	CourseDao coursedao() {
        return new CourseDaoImpl();
    }
	@Bean
    InstructorService   instructorservice() {
        return new   InstructorServiceImpl();
    }
	
	@Bean
	  InstructorDao   instructordao() {
        return new   InstructorDaoImpl();
    }
}
