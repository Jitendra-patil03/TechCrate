package com.Myweb.TechCrate.CoursesRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.CoursesEntities.CSE;
import com.Myweb.TechCrate.CoursesEntities.GetSubjectList;

@Repository
public interface CourseRepoCse extends CrudRepository<CSE,String>{
	@Query(value="Select coursename,description from CSE")
	List<String[]> getSubList();


}
