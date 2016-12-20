package com.casestudy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCT_ATTRIBUTES")
public class AttributeValuePair {
	@Id//@EmbeddedId in case ID itself is a object
	@GeneratedValue(strategy=GenerationType.IDENTITY)// hibernate automatically assigns value default :auto
	private long attributeValueId;
	
	private String attribute;
	
	private String attributeValue;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Product product;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public long getAttributeValueId() {
		return attributeValueId;
	}

	public void setAttributeValueId(long attributeValueId) {
		this.attributeValueId = attributeValueId;
	}

	
}
