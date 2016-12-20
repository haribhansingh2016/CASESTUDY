package com.casestudy.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="PRODUCT_DETAILS")
public class Product {
	@Id//@EmbeddedId in case ID itself is a object
	@GeneratedValue(strategy=GenerationType.IDENTITY)// hibernate automatically assigns value default :auto
	private long productId;

	private String category;
	
	private int price;
	
	private String name;
	
	private String imageSrc;
	
	private String description;
	
	private String brand;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="product",cascade=CascadeType.PERSIST)
	private Collection<AttributeValuePair> listOfAttributeValues = new ArrayList<AttributeValuePair>();

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Collection<AttributeValuePair> getListOfAttributeValues() {
		return listOfAttributeValues;
	}

	public void setListOfAttributeValues(Collection<AttributeValuePair> listOfAttributeValues) {
		this.listOfAttributeValues = listOfAttributeValues;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
