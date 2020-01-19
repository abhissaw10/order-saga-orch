package com.order.ordersagaorch;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.fundutility.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
