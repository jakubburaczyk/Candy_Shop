package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class Wage {
	private int wageId;
	
	private double basicCost;

	private double extraCost;
	
	private String month;
	
	private LocalDate dateOfTransfer;
}
