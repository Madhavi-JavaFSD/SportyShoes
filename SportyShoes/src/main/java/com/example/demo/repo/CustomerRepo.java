package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Shoe;
//<pojo classname , primary key type>
//@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

	@Query(value="select * from Customer c where c.cust_name like %:name%",nativeQuery=true)
	public List<Customer> findByname(@Param("name") String name);
	
	@Query(value="select * from Customer c where c.cust_email=:email and c.cust_password=:custPass",nativeQuery=true)
	public List<Customer> verifyPassword(@Param("email") String email,@Param("custPass") String custPass);

	@Query(value="select * from Customer c where c.cust_email=:sEmail",nativeQuery=true)
	public Customer getByEmail(@Param("sEmail")String sEmail);
}
