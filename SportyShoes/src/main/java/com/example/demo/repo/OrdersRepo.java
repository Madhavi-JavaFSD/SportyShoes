package com.example.demo.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Orders;
//@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer> {
	
	@Query(value="select * from orders o where o.purchase_date >= :fromDate AND o.purchase_date <= :toDate",nativeQuery=true)
	public List<Orders> filterOrders(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);
}

