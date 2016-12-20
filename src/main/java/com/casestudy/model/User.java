package com.casestudy.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id//@EmbeddedId in case ID itself is a object
	@GeneratedValue(strategy=GenerationType.IDENTITY)// hibernate automatically assigns value default :auto
	private long userId;
	
	@Column(unique=true, nullable=false)
	private String emailId;
	
	private String password;
	
	@Column(nullable=false)
	private String firstName;
	
	private String lastName;
	
	@Column(nullable=false)
	private String role = "USER";
	
	@Column(unique=true, nullable=false)
	private String phoneNumber;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="user")
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="cartUser")// for to one to many entities
//	@JoinTable( name="USER_CART",//name of one to many mapping table
//				joinColumns=@JoinColumn(name="USER_ID"),//column name of id from this class
//				inverseJoinColumns=@JoinColumn(name="ORDER_ID"))
	private Collection<Order> listOfOrdersCart = new ArrayList<Order>();//cart orders
	
	public Collection<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(Collection<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="orderedUser")// for to one to many entities
//	@JoinTable( name="USER_ORDER",//name of one to many mapping table
//				joinColumns=@JoinColumn(name="USER_ID"),//column name of id from this class
//				inverseJoinColumns=@JoinColumn(name="ORDER_ID"))
	private Collection<Order> listOfOrders = new ArrayList<Order>();//previous orders
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}    

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public Collection<Order> getListOfOrdersCart() {
		return listOfOrdersCart;
	}

	public void setListOfOrdersCart(Collection<Order> listOfOrdersCart) {
		this.listOfOrdersCart = listOfOrdersCart;
	}

	

	
	
}
