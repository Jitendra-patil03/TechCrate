package com.Myweb.TechCrate.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.Entites.UserRating;

@Repository
public interface UserRatingRepo extends CrudRepository<UserRating,String> {
	
}
