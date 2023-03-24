package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Orders {

	@Id
	@Column(name="orderID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderID;
	
	//private int custID;
	 @ManyToOne(fetch = FetchType.LAZY)   
     @JoinColumn(name="custID", referencedColumnName="custID")
	 private Customer custRef;
	 
	 //private int shoeID;
	 @ManyToOne(fetch = FetchType.LAZY)   
     @JoinColumn(name="shoeID", referencedColumnName="shoeID")
	 private Shoe shoeRef;
	 
	private int shoePrice;
	private int orderQuantity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.sql.Date purchaseDate; 
	
	private int totalAmountPaid;
	
	
}
