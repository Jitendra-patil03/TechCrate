package com.Myweb.TechCrate.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Myweb.TechCrate.Entites.UserQuery;
public interface UserRepository extends CrudRepository<UserQuery,Integer>{

	List<UserQuery> findByDate(String date);

}
