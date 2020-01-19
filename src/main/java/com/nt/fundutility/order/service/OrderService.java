package com.nt.fundutility.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.fundutility.order.model.Order;
import com.nt.fundutility.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order create(Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		order.setOrderCreatedDate(LocalDate.now());
		return orderRepo.save(order);	
	}
	
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public Order getById(String orderId) {
		Optional<Order> op = orderRepo.findById(orderId);
		return op.get();
	}
	
	public List<Order> sarchByFilter(Map<String,String> filterMap) {
		Order order = new Order();
		order.setOrderCreatedBy(filterMap.get("orderCreatedBy"));
		Example<Order> e = Example.of(order); 
		List<Order> op = orderRepo.findAll(e);
		return op;
	}
	
}
