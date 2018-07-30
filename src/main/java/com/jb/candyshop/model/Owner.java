package com.jb.candyshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Owner {

	/**
	 * ID wlasciciela cukierni w bazie danych
	 */
	private int ownerId;
	
	/**
	 * Imie wlasciciela cukierni
	 */
	private String forName;
	
	/**
	 * Nazwisko wlasciciela cukierni
	 */
	private String lastName;
	
	/**
	 * Data, od ktorej wlasciciel jest wlascicielem cukierni
	 */
	private LocalDate sinceWhen;
	
	/**
	 * Data, do ktorej wlasciciel byl wlascicielem cukierni
	 */
	private LocalDate toWhen;
	
	/**
	 * Numer ID cukierni, ktorej jest/byl wlascicielem
	 */
	private int candyShopId;
	
	/**
	 * Numer id wlasciciela cukierni
	 */
	private String id;
}
