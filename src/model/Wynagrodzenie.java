package model;

import java.time.LocalDate;

public class Wynagrodzenie {
	private int id_wynagrodzenie;
	
	private double kwota_podstawowa;
	
	private double kwota_dodatkowa;
	
	private String miesiac;
	
	private LocalDate data_wyplacenia;

	/**
	 * @param id_wynagrodzenia
	 * @param kwotaPodstawowa
	 * @param kwotaDodatkowa
	 * @param miesiac
	 * @param dataWyplacenia
	 */
//	public Wynagrodzenie(int id_wynagrodzenia, double kwotaPodstawowa, double kwotaDodatkowa, String miesiac,
//			LocalDate dataWyplacenia) {
//		this.id_wynagrodzenia = id_wynagrodzenia;
//		this.kwotaPodstawowa = kwotaPodstawowa;
//		this.kwotaDodatkowa = kwotaDodatkowa;
//		this.miesiac = miesiac;
//		this.dataWyplacenia = dataWyplacenia;
//	}
	
	/**
	 * Bezparametrowy konstruktor obiektu klasy adres
	 */
	public Wynagrodzenie(){
		super();
	}

	/**
	 * @return the id_wynagrodzenia
	 */
	public int getId_wynagrodzenia() {
		return id_wynagrodzenie;
	}

	/**
	 * @param id_wynagrodzenia the id_wynagrodzenia to set
	 */
	public void setId_wynagrodzenia(int id_wynagrodzenia) {
		this.id_wynagrodzenie = id_wynagrodzenia;
	}

	/**
	 * @return the kwotaPodstawowa
	 */
	public double getKwotaPodstawowa() {
		return kwota_podstawowa;
	}

	/**
	 * @param kwotaPodstawowa the kwotaPodstawowa to set
	 */
	public void setKwotaPodstawowa(double kwotaPodstawowa) {
		this.kwota_podstawowa = kwotaPodstawowa;
	}

	/**
	 * @return the kwotaDodatkowa
	 */
	public double getKwotaDodatkowa() {
		return kwota_dodatkowa;
	}

	/**
	 * @param kwotaDodatkowa the kwotaDodatkowa to set
	 */
	public void setKwotaDodatkowa(double kwotaDodatkowa) {
		this.kwota_dodatkowa = kwotaDodatkowa;
	}

	/**
	 * @return the miesiac
	 */
	public String getMiesiac() {
		return miesiac;
	}

	/**
	 * @param miesiac the miesiac to set
	 */
	public void setMiesiac(String miesiac) {
		this.miesiac = miesiac;
	}

	/**
	 * @return the dataWyplacenia
	 */
	public LocalDate getDataWyplacenia() {
		return data_wyplacenia;
	}

	/**
	 * @param dataWyplacenia the dataWyplacenia to set
	 */
	public void setDataWyplacenia(LocalDate dataWyplacenia) {
		this.data_wyplacenia = dataWyplacenia;
	}
	
	
	
}
