package com.jpahibernatespringboot.jpahib.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.jpahibernatespringboot.jpahib.course.Course;
//import com.jpahibernatespringboot.jpahib.course.JPA.CourseJpaRepository;
import com.jpahibernatespringboot.jpahib.course.springdatajpa.CourseSpringDataJpaRepository;
//import com.jpahibernatespringboot.jpahib.course.jdbc.CourseJdbcRepository;
@Component
public class CourseCommandLineRunner implements CommandLineRunner
{
//     @Autowired
//	private CourseJdbcRepository repository;
	
	
//     @Autowired
// 	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
     
     
	@Override
	public void run(String... args) throws Exception 
	{
		repository.save(new Course(1,"Learn SonarQube","Ujjwal"));
		repository.save(new Course(2,"Learn GraphQL","Ujjwal"));
	    repository.save(new Course(3,"Learn RabbitMQ","Ujjwal"));

		repository.deleteById(1l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(2l));
		
		System.out.println(repository.findAll()); //kind of like select *
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Ujjwal"));
		System.out.println(repository.findByName("Learn GraphQL"));
	}

}
