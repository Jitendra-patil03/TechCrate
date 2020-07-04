package com.Myweb.TechCrate.CoursesRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.CoursesEntities.Aptitude;

@Repository
public interface CourseRepoApti extends CrudRepository<Aptitude,String>{
	
	@Query(value="Select coursename,description from Aptitude")
	List<String[]> getSubList();
	
}
