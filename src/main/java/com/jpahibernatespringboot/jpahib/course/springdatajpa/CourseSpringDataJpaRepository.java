package com.jpahibernatespringboot.jpahib.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpahibernatespringboot.jpahib.course.Course;

public interface CourseSpringDataJpaRepository  extends JpaRepository<Course,Long>
{
  //we can create our own methods
	
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
