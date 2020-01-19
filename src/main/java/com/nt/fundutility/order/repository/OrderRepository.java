package com.nt.fundutility.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.fundutility.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
