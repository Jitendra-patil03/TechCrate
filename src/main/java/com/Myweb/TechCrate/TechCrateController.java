package com.Myweb.TechCrate;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Myweb.TechCrate.CoursesEntities.Aptitude;
import com.Myweb.TechCrate.CoursesEntities.CSE;
import com.Myweb.TechCrate.CoursesEntities.GetSubjectList;
import com.Myweb.TechCrate.CoursesEntities.ME;
import com.Myweb.TechCrate.CoursesEntities.School;
import com.Myweb.TechCrate.Entites.Admin;
import com.Myweb.TechCrate.Entites.UserQuery;
import com.Myweb.TechCrate.Entites.UserRating;
import com.Myweb.TechCrate.Service.AdminService;
import com.Myweb.TechCrate.Service.CourseService;
import com.Myweb.TechCrate.Service.TechService;

@RestController
@CrossOrigin(origins="*")
public class TechCrateController {
	@Autowired
	private TechService techService;
	
	@RequestMapping("/")
	public String base() {
		return "techcrate is running";
	}
	@PostMapping("/contactUs")
	public String addUserQuery(@RequestBody UserQuery query){
		try {
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			query.setDate(""+f.format(d));
			System.out.println(query.toString());
			techService.saveUserQuery(query);
		} catch(Exception e) {
			return "Message Not Sent..!";
		}
		return "Message sent successfully..!";
	}
	
	@GetMapping("/getAllQueryByDate/{date}")
	public List<UserQuery> allQueries(@PathVariable String date) {
		System.out.println(date);
		return techService.getallRequest(date);
	}
	@GetMapping("/getAllQuery")
	public List<UserQuery> allQueries() {
	
		return techService.getAllQueries();
	}
	
	
	// admin
	@Autowired
	private AdminService adminService;
	@PostMapping(value="/registerAdmin",consumes="application/json")
	public String registerAdmin(@RequestBody Admin admin) {
		try {
			if(admin.getAuthid().equals("3699")){
				System.out.println(admin.toString());
				adminService.saveAdmin(admin);
			} else {
				return "authId not Match";
			}
		} catch(Exception e) {
			System.out.println(e);
			return "Unsuccessfull";
		}
		return "register successfull";
	}
	@GetMapping("/login/{email}/{password}")
	public String loginAdmin(@PathVariable String email, @PathVariable String password) {
		
		String ad = adminService.getAdmin(email, password);
		if(ad != null) {
			return "success";
		}else {
			return "fail";
		}
	}
	@Autowired
	private CourseService courseService;
	@PostMapping(value="/uploadCourse",headers="Content-Type=multipart/form-data")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("courseName") String courseName,@RequestParam("category") String category,@RequestParam("description") String description) {
		try {
			if(category.equals("SCHOOL")) {
				School school = new School(courseName,file.getOriginalFilename(),file.getContentType(),file.getBytes(),description);
				Object obj = courseService.saveCourseScl(school);
				if(obj != null)
					return "school Successfully uploaded!";
			} else if(category.equals("ENG_CSE")) {
				CSE cse = new CSE(courseName,file.getOriginalFilename(),file.getContentType(),file.getBytes(),description);
				Object obj = courseService.saveCourseCs(cse);
				if(obj != null)
					return "CSE Successfully uploaded!";
			} else if(category.equals("ENG_ME")) {
				ME me = new ME(courseName,file.getOriginalFilename(),file.getContentType(),file.getBytes(), description);
				Object obj = courseService.saveCourseMe(me);
				if(obj != null)
					return "ME Successfully uploaded!";
			} else if(category.equals("APTITUDE")) {
				Aptitude apti = new Aptitude(courseName,file.getOriginalFilename(),file.getContentType(),file.getBytes(), description);
				Object obj = courseService.saveCourseApti(apti);
				if(obj != null)
					return "Successfully uploaded!";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("errr");
			//e.printStackTrace();
		}
		return "Unsuccessfull";
	}
	
	@GetMapping("/getCourseSubjects/{category}")
	public List<GetSubjectList> getCourseList(@PathVariable String category) {
		List l;
		try {
		l = this.courseService.getListSub(category);
		if(l==null) {
			l = new ArrayList<GetSubjectList>();
			GetSubjectList gs = new GetSubjectList();
			gs.course_Name="course Not Available";
			gs.description = "sorry for inconvenience!";
			l.add(gs);
			return l;
		}}catch(Exception e) {
			l = new ArrayList<GetSubjectList>();
			GetSubjectList gs = new GetSubjectList();
			gs.course_Name=e.getMessage();
			gs.description = "sorry for inconvenience!";
			l.add(gs);
			return l;
		}
		return l;
		
	}
	
	//get CSE pdf 
	@GetMapping("/ENG_CSEPdf/{courseName}")
	public CSE getCSEPdf(@PathVariable String courseName) {
		return this.courseService.getCseSubPdf(courseName).get();
	}
	//get ME pdf 
	@GetMapping("/ENG_MEPdf/{courseName}")
	public ME getMEEPdf(@PathVariable String courseName) {
		return this.courseService.getMeSubPdf(courseName).get();
	}
	
	//get apti pdf 
	@GetMapping("/APTITUDEPdf/{courseName}")
	public Aptitude getAptiPdf(@PathVariable String courseName) {
		return this.courseService.getAptiSubPdf(courseName).get();
	}
	//get School pdf 
	@GetMapping("/SCHOOLPdf/{courseName}")
	public School getSclSubjectPdf(@PathVariable String courseName) {
		return this.courseService.getSclSubPdf(courseName).get();
	}
	
	//user rating controller
	
	@PostMapping("/userRating")
	public String rating(@RequestBody UserRating userRate) {
		try {
			if(this.techService.saveRating(userRate) != null) {
				return "Your valuable rating is counted.";
			}
		}catch(Exception e) {
			return "not submitted:- error"+e.getMessage();
		}
		return "";
	}

	
}
