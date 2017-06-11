package model;

import java.time.LocalDate;

public class Wlasciciel {

	/**
	 * ID wlasciciela cukierni w bazie danych
	 */
	private int id_wlasciciel;
	
	/**
	 * Imie wlasciciela cukierni
	 */
	private String imie;
	
	/**
	 * Nazwisko wlasciciela cukierni
	 */
	private String nazwisko;
	
	/**
	 * Data, od ktorej wlasciciel jest wlascicielem cukierni
	 */
	private LocalDate od_kiedy;
	
	/**
	 * Data, do ktorej wlasciciel byl wlascicielem cukierni
	 */
	private LocalDate do_kiedy;
	
	/**
	 * Numer ID cukierni, ktorej jest/byl wlascicielem
	 */
	private int id_cukierni;
	
	/**
	 * Numer pesel wlasciciela cukierni
	 */
	private String pesel;
	
	/**
	 * Bezparametrowy konstruktor klasy Wlasciciel
	 */
	public Wlasciciel(){
		super();
	}

	
	/**
	 * @return the id_wlasciciel
	 */
	public int getId_wlasciciel() {
		return id_wlasciciel;
	}

	/**
	 * @param id_wlasciciel the id_wlasciciel to set
	 */
	public void setId_wlasciciel(int id_wlasciciel) {
		this.id_wlasciciel = id_wlasciciel;
	}

	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}

	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}

	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}

	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * @return the od_kiedy
	 */
	public LocalDate getOd_kiedy() {
		return od_kiedy;
	}

	/**
	 * @param od_kiedy the od_kiedy to set
	 */
	public void setOd_kiedy(LocalDate od_kiedy) {
		this.od_kiedy = od_kiedy;
	}

	/**
	 * @return the do_kiedy
	 */
	public LocalDate getDo_kiedy() {
		return do_kiedy;
	}

	/**
	 * @param do_kiedy the do_kiedy to set
	 */
	public void setDo_kiedy(LocalDate do_kiedy) {
		this.do_kiedy = do_kiedy;
	}

	/**
	 * @return the id_cukierni
	 */
	public int getId_cukierni() {
		return id_cukierni;
	}

	/**
	 * @param id_cukierni the id_cukierni to set
	 */
	public void setId_cukierni(int id_cukierni) {
		this.id_cukierni = id_cukierni;
	}


	/**
	 * @return the pesel
	 */
	public String getPesel() {
		return pesel;
	}


	/**
	 * @param pesel the pesel to set
	 */
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	
	
	
}
