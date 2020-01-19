package com.nt.fundutility.order.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order_master")
public class Order {
	@Id
	@Indexed
	private String orderId;
	private String[] orderItems;
	private Long orderAmount;
	private LocalDate orderCreatedDate;
	@Indexed
	private String orderCreatedBy;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String[] getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(String[] orderItems) {
		this.orderItems = orderItems;
	}
	public Long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public LocalDate getOrderCreatedDate() {
		return orderCreatedDate;
	}
	public void setOrderCreatedDate(LocalDate orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}
	public String getOrderCreatedBy() {
		return orderCreatedBy;
	}
	public void setOrderCreatedBy(String orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}
	
	
}
