package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CandyShop {
	
	private int candyShopId;
	
	private String name;
	
	private String owner;
	
	private String nip;
	
	private String regon;

	private String telephone;

	private String webPage;

	private String email;

	private List<Address> addresses;

	private List<Worker> workers;

	private List<Product> products;

	private List<Owner> owners;
}
