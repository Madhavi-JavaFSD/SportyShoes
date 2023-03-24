package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.Id;

import com.example.demo.model.Shoe;
@Repository
public interface ShoeRepo extends JpaRepository<Shoe,Integer> {
	
	@Query(value="select * from Shoe s where s.shoe_name like %:name%",nativeQuery=true)
	public List<Shoe> findByname(@Param("name") String name);

}
