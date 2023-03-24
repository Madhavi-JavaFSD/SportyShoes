package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SportyShoesAdmin")
@Data
public class Admin {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminID;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
}
