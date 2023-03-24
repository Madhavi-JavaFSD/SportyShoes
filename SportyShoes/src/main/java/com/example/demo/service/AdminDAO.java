package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.repo.AdminRepo;

@Service
public class AdminDAO {


	@Autowired
	private AdminRepo repo;
	Logger log = Logger.getAnonymousLogger();

	public Admin addAdmin(Admin u) {
		return repo.save(u);
	}
	public List<Admin> getAllAdmin(){
		return repo.findAll();
	}
	public Admin getAdminById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}

	}
	public Admin updateAdmin(int id, Admin newAdmin) {
		if(repo.findById(id).isPresent()) {
			Admin oldAdmin= repo.findById(id).get();
			oldAdmin.setAdminName(newAdmin.getAdminName());
			oldAdmin.setAdminEmail(newAdmin.getAdminEmail());
			oldAdmin.setAdminPassword(newAdmin.getAdminPassword());

			return repo.save(oldAdmin);
		}
		else {
			return null;
		}
	}


	public boolean deleteAdmin(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}

		else {
			return false;
		}
	}
	public Admin findByEmail(String sAdminEmail) {
		Admin a = repo.getByEmail(sAdminEmail);
		return a;
	}
	public boolean checkPassword(String sAdminEmail, String sAdminPass) {
		boolean isPass = false;
		log.info("sAdminName in DAO--" + sAdminEmail);
		log.info("sAdminPass in DAO--" + sAdminPass);
		List<Admin> list = repo.verifyPassword(sAdminEmail, sAdminPass);
		if(list!=null && list.size() >0)
		{
			isPass = true;
			for(int i =0; i<list.size();i++) 
			{
				log.info("Names+++" + list.get(i));
			}
			
		}		
		return isPass;
	}




}
