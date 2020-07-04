package com.Myweb.TechCrate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myweb.TechCrate.Entites.Admin;
import com.Myweb.TechCrate.Repository.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		
		return adminRepository.save(admin);
		
	}
	public String getAdmin(String email,String password) {
		return adminRepository.getByIdPass(email,password);
	}
	
	
}
