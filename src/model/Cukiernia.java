package model;

import java.util.List;

public class Cukiernia {
	
	private int id_cukierni;
	
	private String nazwa;
	
	private String wlasciciel;
	
	private String nip;
	
	private String regon;
	
	private String nrTelefonu;
	
	private String stronaInternetowa;
	
	private String email;
	
	private List<Adres> adresy;
	
	private List<Pracownik> pracownicy;
	
	private List<Produkt> produkty;
	
	private List<Wlasciciel> wlasciciele;
	
	

	

	/**
	 * @param idCukierni
	 * @param nazwa
	 * @param wlasciciel
	 * @param nip
	 * @param regon
	 * @param nrTelefonu
	 * @param stronaInternetowa
	 * @param email
	 */
//	public Cukiernia(int idCukierni, String nazwa, String wlasciciel, String nip, String regon,
//			String nrTelefonu, String stronaInternetowa, String email) {
//		this.id_cukierni = idCukierni;
//		this.nazwa = nazwa;
//		this.wlasciciel = wlasciciel;
//		this.nip = nip;
//		this.regon = regon;
//		this.nrTelefonu = nrTelefonu;
//		this.stronaInternetowa = stronaInternetowa;
//		this.email = email;
//	}
	
	/**
	 * Bezparametrowy konstruktor obiektu klasy Cukiernia
	 */
	public Cukiernia(){
		super();
	}

	/**
	 * @return the idCukierni
	 */
	public int getIdCukierni() {
		return id_cukierni;
	}

	/**
	 * @param idCukierni the idCukierni to set
	 */
	public void setIdCukierni(int idCukierni) {
		this.id_cukierni = idCukierni;
	}

	/**
	 * @return the nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}

	/**
	 * @param nazwa the nazwa to set
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	/**
	 * @return the wlasciciel
	 */
	public String getWlasciciel() {
		return wlasciciel;
	}

	/**
	 * @param wlasciciel the wlasciciel to set
	 */
	public void setWlasciciel(String wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	/**
	 * @return the nip
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * @param nip the nip to set
	 */
	public void setNip(String nip) {
		this.nip = nip;
	}

	/**
	 * @return the regon
	 */
	public String getRegon() {
		return regon;
	}

	/**
	 * @param regon the regon to set
	 */
	public void setRegon(String regon) {
		this.regon = regon;
	}

	/**
	 * @return the nrTelefonu
	 */
	public String getNrTelefonu() {
		return nrTelefonu;
	}

	/**
	 * @param nrTelefonu the nrTelefonu to set
	 */
	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	/**
	 * @return the stronaInternetowa
	 */
	public String getStronaInternetowa() {
		return stronaInternetowa;
	}

	/**
	 * @param stronaInternetowa the stronaInternetowa to set
	 */
	public void setStronaInternetowa(String stronaInternetowa) {
		this.stronaInternetowa = stronaInternetowa;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
