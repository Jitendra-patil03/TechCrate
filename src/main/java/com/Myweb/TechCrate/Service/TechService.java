package com.Myweb.TechCrate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myweb.TechCrate.Entites.UserQuery;
import com.Myweb.TechCrate.Entites.UserRating;
import com.Myweb.TechCrate.Entites.Usercount;
import com.Myweb.TechCrate.Repository.UserCount;
import com.Myweb.TechCrate.Repository.UserRatingRepo;
import com.Myweb.TechCrate.Repository.UserRepository;

@Service
public class TechService {
	@Autowired
	private UserRepository userRepository;
	
	//postMethod call
	public UserQuery saveUserQuery(UserQuery query) {
		return userRepository.save(query);
	}
	//get method 
	public List<UserQuery> getallRequest(String date){
		return userRepository.findByDate(date);
	}
	public List<UserQuery> getAllQueries(){
		return (List<UserQuery>) userRepository.findAll();
	}
	//user rating service
	@Autowired
	private UserRatingRepo userRate;
	public UserRating saveRating(UserRating ur) {
		return this.userRate.save(ur); 
		//return null;
		
	}
	//user visit Count
	@Autowired
	private UserCount userRepo;
	public Integer setUserVisitCount() {
		Usercount uc;
		try {
		 uc = userRepo.findById(1).get();
		}catch(Exception e) {
			uc = new Usercount();
			uc.setId(1);
			uc.setCount(0);
		}
		
			uc.setCount(uc.getCount()+1);
	
		return (userRepo.save(uc)).getCount();
	}
	
}
