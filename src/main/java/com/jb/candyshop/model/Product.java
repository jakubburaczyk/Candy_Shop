package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

	private int productId;
	
	private String name;
	
	private double productionCost;
	
	private double bruttoPrice;
	
	private int tax;
	
	private int weight;
}
