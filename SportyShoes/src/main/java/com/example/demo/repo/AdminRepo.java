package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
//<pojo classname , primary key type>
//@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {


	@Query(value="select * from sporty_shoes_admin a where a.admin_email=:sAdminEmail and a.admin_password=:sAdminPass",nativeQuery=true)
	public List<Admin> verifyPassword(@Param("sAdminEmail") String sAdminEmail,@Param("sAdminPass") String sAdminPass);

	@Query(value="select * from sporty_shoes_admin a where a.admin_email=:sEmail",nativeQuery=true)
	public Admin getByEmail(@Param("sEmail")String sEmail);
}

