package com.Myweb.TechCrate.CoursesRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.CoursesEntities.GetSubjectList;
import com.Myweb.TechCrate.CoursesEntities.School;

@Repository
public interface CourseRepoSchool extends CrudRepository<School,String>{
	@Query(value="Select coursename,description from School")
	List<String[]> getSubList();

}
