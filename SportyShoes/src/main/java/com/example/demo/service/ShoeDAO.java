package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Shoe;
import com.example.demo.repo.ShoeRepo;

@Service
public class ShoeDAO {

	
	@Autowired
	private ShoeRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	public Shoe addShoe(Shoe u) {
		return repo.save(u);
	}
	public List<Shoe> getAllShoe(){
		return repo.findAll();
	}
	public Shoe getShoeById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}		
	}
	public List<Shoe> findbyname(String name){
		log.info("Shoe name in DAO--" + name);
		List<Shoe> list = repo.findByname(name);
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

	public Shoe updateShoe(int id, Shoe newShoe) {
		log.info("Shoe ID--" + id);
		if(repo.findById(id).isPresent()) {
			Shoe oldShoe= repo.findById(id).get();
			oldShoe.setShoeName(newShoe.getShoeName());
			oldShoe.setShoePrice(newShoe.getShoePrice());
			oldShoe.setShoeQuantity(newShoe.getShoeQuantity());	
			log.info("new shoe--" + newShoe);
			return repo.save(oldShoe);
		}
		else {
			return null;
		}
	}
	public Shoe updateShoeQuantity(Shoe selectedShoe, int newShoeQuantity) {
		Shoe newShoe = null;
		if(selectedShoe != null) {
			selectedShoe.setShoeQuantity(newShoeQuantity);	
			return repo.save(selectedShoe);
		}		
		return newShoe;		
	}
	
	public boolean deleteShoe(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}		
		else {
			return false;
		}
	}
}
