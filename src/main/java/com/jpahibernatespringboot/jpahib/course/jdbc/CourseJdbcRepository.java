package com.jpahibernatespringboot.jpahib.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpahibernatespringboot.jpahib.course.Course;

@Repository
public class CourseJdbcRepository
{
	@Autowired
   private JdbcTemplate springJdbcTemplate;
   
   private static String INSERT_QUERY=
		   """ 
   		     insert into course(id,name,author) values(?,?,?);
   		   """ ;
   public void insert(Course course)
   {
	   springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
   }
   
   private static String Delete_QUERY=
		   """ 
   		     delete from course where id=?;
   		   """ ;
   public void delete(long id)
   {
	   springJdbcTemplate.update(Delete_QUERY,id);
   }
   
   private static String SELECT_QUERY=
		   """ 
   		     select * from course where id=?;
   		   """ ;
   public Course findById(long id)
   {  
	   return springJdbcTemplate.queryForObject(SELECT_QUERY,
			   new BeanPropertyRowMapper<>(Course.class),
			   id);
   }
}
 