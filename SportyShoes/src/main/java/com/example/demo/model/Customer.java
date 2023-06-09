package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custID;
	private String custName;
	private String custEmail;
	private String custPassword;
}
