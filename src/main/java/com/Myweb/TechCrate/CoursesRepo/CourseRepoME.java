package com.Myweb.TechCrate.CoursesRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.CoursesEntities.GetSubjectList;
import com.Myweb.TechCrate.CoursesEntities.ME;

@Repository
public interface CourseRepoME extends CrudRepository<ME,String>{
	@Query(value="Select coursename,description from ME")
	List<String[]> getSubList();

}
