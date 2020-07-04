package com.Myweb.TechCrate.Repository;
import com.Myweb.TechCrate.Entites.Admin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin,String>  {
	@Query(value="select email from Admin where email=?1 and password = ?2")
	String getByIdPass(String email, String password);

}
