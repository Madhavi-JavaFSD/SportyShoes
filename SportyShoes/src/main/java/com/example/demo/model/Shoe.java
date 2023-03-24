package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repo.ShoeRepo;

import lombok.Data;

@Entity
@Data
public class Shoe {
	
	@Id 
	@Column(name="shoeID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shoeID;
	private String shoeName;
	private int shoePrice;
	private int shoeQuantity;
	
}
