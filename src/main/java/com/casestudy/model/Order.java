package com.casestudy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDER_DETAILS")
public class Order {
	@Id//@EmbeddedId in case ID itself is a object
	@GeneratedValue(strategy=GenerationType.IDENTITY)// hibernate automatically assigns value default :auto
	private long orderId;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID_CART")
	private User cartUser;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID_ORDERED")
	private User orderedUser;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Address Orderaddress;
	
	private int quantity = 1;//default
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate OrderDate;
	
	public User getCartUser() {
		return cartUser;
	}

	public void setCartUser(User cartUser) {
		this.cartUser = cartUser;
	}

	public User getOrderedUser() {
		return orderedUser;
	}

	public void setOrderedUser(User orderedUser) {
		this.orderedUser = orderedUser;
	}

	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Address getOrderaddress() {
		return Orderaddress;
	}

	public void setOrderaddress(Address orderaddress) {
		Orderaddress = orderaddress;
	}

	public LocalDate getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}

	

	
	
	
}
