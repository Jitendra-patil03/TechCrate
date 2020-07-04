package com.Myweb.TechCrate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myweb.TechCrate.Entites.UserQuery;
import com.Myweb.TechCrate.Entites.UserRating;
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
	
}
