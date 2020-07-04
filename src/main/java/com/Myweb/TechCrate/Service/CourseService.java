package com.Myweb.TechCrate.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myweb.TechCrate.CoursesEntities.Aptitude;
import com.Myweb.TechCrate.CoursesEntities.CSE;
import com.Myweb.TechCrate.CoursesEntities.ME;
import com.Myweb.TechCrate.CoursesEntities.School;
import com.Myweb.TechCrate.CoursesRepo.CourseRepoApti;
import com.Myweb.TechCrate.CoursesRepo.CourseRepoCse;
import com.Myweb.TechCrate.CoursesRepo.CourseRepoME;
import com.Myweb.TechCrate.CoursesRepo.CourseRepoSchool;
import com.Myweb.TechCrate.CoursesEntities.GetSubjectList;

@Service
public class CourseService {
	@Autowired
	CourseRepoCse repoCs;
	@Autowired
	CourseRepoApti repoApti;
	@Autowired
	CourseRepoSchool repoScl;
	@Autowired
	CourseRepoME repoMe;
	// save CSE related courses
	 
	public Object saveCourseCs(CSE file) {
		return repoCs.save(file);
	}
	//save ME related courses
	public Object saveCourseMe(ME file) {
		return repoMe.save(file);
	}
	//save School realated courses
	public Object saveCourseScl(School file) {
		return repoScl.save(file);
	}
	//save Apti courses
	public Object saveCourseApti(Aptitude file) {
		return repoApti.save(file);
	}
	
	//get data
	//this method return how many sub
	public List<GetSubjectList> getListSub(String cat) {
		if(cat.equals("ENG_CSE")) {
			ListIterator it = this.repoCs.getSubList().listIterator();
			List<GetSubjectList> l2= new ArrayList();
			while(it.hasNext()) {
				String s[] = (String[]) it.next();
				GetSubjectList gl = new GetSubjectList();
				gl.course_Name = s[0];
				gl.description = s[1];
				l2.add(gl);
			}
			return l2;
			
		} else if(cat.equals("ENG_ME")) {
			ListIterator it =  this.repoMe.getSubList().listIterator();
			List<GetSubjectList> l2= new ArrayList();
			while(it.hasNext()) {
				String s[] = (String[]) it.next();
				GetSubjectList gl = new GetSubjectList();
				gl.course_Name = s[0];
				gl.description = s[1];
				l2.add(gl);
			}
			return l2;
			
		} else if(cat.equals("APTITUDE")) {
			ListIterator it =  this.repoApti.getSubList().listIterator();
			List<GetSubjectList> l2= new ArrayList();
			while(it.hasNext()) {
				String s[] = (String[]) it.next();
				GetSubjectList gl = new GetSubjectList();
				gl.course_Name = s[0];
				gl.description = s[1];
				l2.add(gl);
			}
			return l2;
		}else if(cat.equals("SCHOOL")) {
			ListIterator it =  this.repoScl.getSubList().listIterator();
			List<GetSubjectList> l2= new ArrayList();
			while(it.hasNext()) {
				String s[] = (String[]) it.next();
				GetSubjectList gl = new GetSubjectList();
				gl.course_Name = s[0];
				gl.description = s[1];
				l2.add(gl);
			}
			return l2;
		}
		return null;
	}
	//CSE sub pdf
	public Optional<CSE> getCseSubPdf(String name) {
		return this.repoCs.findById(name);
	}
	public Optional<ME> getMeSubPdf(String name) {
		return this.repoMe.findById(name);
	}
	public Optional<Aptitude> getAptiSubPdf(String name) {
		return this.repoApti.findById(name);
	}
	public Optional<School> getSclSubPdf(String name) {
		return this.repoScl.findById(name);
	}

}
