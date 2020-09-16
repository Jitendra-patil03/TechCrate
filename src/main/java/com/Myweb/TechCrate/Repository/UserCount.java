package com.Myweb.TechCrate.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Myweb.TechCrate.Entites.Usercount;

@Repository
public interface UserCount extends CrudRepository<Usercount,Integer>  {


}
