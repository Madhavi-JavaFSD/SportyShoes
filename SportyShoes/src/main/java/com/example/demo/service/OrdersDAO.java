package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.repo.OrdersRepo;
@Service
public class OrdersDAO {

	
	@Autowired
	private OrdersRepo repo;
	Logger log = Logger.getAnonymousLogger();
	
	public Orders addOrder(Orders u) {
		return repo.save(u);
	}
	public List<Orders> getAllOrder(){
		return repo.findAll();
	}
	public List<Orders> filterOrders(Date fromDate, Date toDate)
	{		
		List<Orders> list = repo.filterOrders(fromDate, toDate);
		return list;
	}
	public Orders getOrderById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	public Orders updateOrder(int id, Orders newOrder) {
		if(repo.findById(id).isPresent()) {
			Orders oldOrder= repo.findById(id).get();
			oldOrder.setOrderQuantity(newOrder.getOrderQuantity());
			oldOrder.setPurchaseDate(newOrder.getPurchaseDate());
			oldOrder.setShoePrice(newOrder.getShoePrice());
			oldOrder.setShoeRef(newOrder.getShoeRef());
			oldOrder.setCustRef(newOrder.getCustRef());
			oldOrder.setTotalAmountPaid(newOrder.getTotalAmountPaid());
			return repo.save(oldOrder);
		}
		else {
			return null;
		}
	}
	
	
	public boolean deleteOrder(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	


}
