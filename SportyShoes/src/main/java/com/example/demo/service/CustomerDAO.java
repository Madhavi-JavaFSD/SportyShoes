package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
@Service
public class CustomerDAO {



	@Autowired
	private CustomerRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	public Customer addcust(Customer u) {
		return repo.save(u);
	}
	public List<Customer> getAllcust(){
		return repo.findAll();
	}
	public Customer getcustById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}

	}
	public List<Customer> findbyname(String name){
		log.info("Cust name in DAO--" + name);
		List<Customer> list = repo.findByname(name);
		log.info("list size in DAO--" + list.size());
		if(list!=null && list.size() >0)
		{
			for(int i =0; i<list.size();i++) 
			{
				log.info("Names----" + list.get(i));
			}
		}		
		return repo.findByname(name);
	}
	public Customer findByEmail(String sEmail)
	{
		Customer cust = repo.getByEmail(sEmail);
		return cust;
	}
	public boolean checkPassword(String sCustEmail, String sCustPass) {
		boolean isPass = false;
		log.info("sCustName in DAO--" + sCustEmail);
		log.info("sCustPass in DAO--" + sCustPass);
		List<Customer> list = repo.verifyPassword(sCustEmail, sCustPass);
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
	public Customer updatecust(int id, Customer newcust) {
		if(repo.findById(id).isPresent()) {
			Customer oldcust= repo.findById(id).get();
			oldcust.setCustName(newcust.getCustName());
			oldcust.setCustEmail(newcust.getCustEmail());
			oldcust.setCustPassword(newcust.getCustPassword());

			return repo.save(oldcust);
		}
		else {
			return null;
		}
	}


	public boolean deletecust(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}

		else {
			return false;
		}
	}





}
