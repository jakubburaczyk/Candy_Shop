package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Worker {

	private int workerId;
	
	private String forName;
	
	private String latsName;
	
	private String gender;
	
	private LocalDate dayOfBirth;
	
	private LocalDate dateOfEmployment;
	
	private String pesel;
	
	private String job;
	
	private String desc;
	
	private String telephone;
	
	private String account;
	
	private LocalDate dateOfUnemployment;
	
	private int candyShopId;
	
	private int addressId;
	
	private Address address;
}
