package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Address {
	private int addressId;
	
	private String town;
	
	private String street;
	
	private String apartamentNumber;
	
	private String buildingNumber;
	
	private int postId;
	
	private int candySchopId;
	
	private int providerId;
	
	private Post post;
}
