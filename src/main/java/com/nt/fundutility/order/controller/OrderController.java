package com.nt.fundutility.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.fundutility.order.model.Order;
import com.nt.fundutility.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping("/v1/order/create")
	public Order create(@RequestBody Order order) {
		return orderService.create(order);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/v1/order/all")
	public List<Order> getAll() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/v1/order/{orderId}")
	public Order getAll(@PathVariable String orderId) {
		return orderService.getById(orderId);
	}
	
	@GetMapping("/v1/order/search?filter={filter}")
	public List<Order> search(@RequestParam("filter") String filter) {
		Map<String,String> filterMap = new HashMap<>();
		Optional<String> o = Optional.ofNullable(filter);
		List<String> filters = Stream.of(o.get().split("|")).map(s->new String(s)).collect(Collectors.toList());
		filters.forEach(s->{String[] sa = s.split("::");filterMap.put(sa[0], sa[1]);});
		return orderService.sarchByFilter(filterMap);
	}
	
}
