package com.supermarketapp.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("unused")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "product")
public class Product {

	// @GeneratedValue(strategy=GenerationType.IDENTITY);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	private String imageUrl;

	private String productName;

	private String measurement;

	private int price;
}
