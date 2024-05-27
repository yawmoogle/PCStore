package com.podProject.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	@Column(unique = true)
	private String productName;
	private String productPrice;

	@OneToMany
	private List<Memory> memory;

	@ManyToOne
	private ComputerProcessor computerProcessor;

	@ManyToOne
	private Storage storage;

	@ManyToOne
	private ComputerCase computerCase;

	@ManyToOne
	private Cooler cooler;

	@ManyToOne
	private PowerSupply powerSupply;

	@ManyToOne
	private VideoCard videoCard;


	
	public Product(String productName, String productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	

}
