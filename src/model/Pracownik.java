package model;

import java.time.LocalDate;
import java.util.List;

public class Pracownik {

	private int id_pracownika;
	
	private String imie;
	
	private String nazwisko;
	
	private String plec;
	
	private LocalDate data_urodzenia;
	
	private LocalDate data_zatrudnienia;
	
	private String pesel;
	
	private String stanowisko;
	
	private String opis;
	
	private String nrTelefonu;
	
	private String nrKonta;
	
	private LocalDate data_zwolnienia;
	
	private int id_cukierni;
	
	private int id_adres;
	
	private Adres adres;
	
	private List<Wynagrodzenie> wynagrodzenia;



	/**
	 * @param id_pracownika
	 * @param imie
	 * @param nazwisko
	 * @param plec
	 * @param dataUrodzenia
	 * @param dataZatrudnienia
	 * @param pesel
	 * @param stanowisko
	 * @param opis
	 * @param nrTelefonu
	 * @param nrKonta
	 * @param id_cukierni
	 * @param id_adres
	 */
	/*public Pracownik(int id_pracownika, String imie, String nazwisko, String plec,
			LocalDate dataUrodzenia, LocalDate dataZatrudnienia, String pesel, String stanowisko, String opis,
			String nrTelefonu, String nrKonta, int id_cukierni, int id_adres) {
		this.id_pracownika = id_pracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.plec = plec;
		this.data_urodzenia = dataUrodzenia;
		this.data_zatrudnienia = dataZatrudnienia;
		this.pesel = pesel;
		this.stanowisko = stanowisko;
		this.opis = opis;
		this.nrTelefonu = nrTelefonu;
		this.nrKonta = nrKonta;
		this.id_cukierni = id_cukierni;
		this.id_adres = id_adres;
	}*/

	/**
	 * Bezparametrowy konstruktor obiektu klasy Pracownik
	 */
	public Pracownik(){
		super();
	}
	
	/**
	 * @return the adres
	 */
	public Adres getAdres() {
		return adres;
	}

	/**
	 * @param adres the adres to set
	 */
	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	/**
	 * @return the id_pracownika
	 */
	public int getId_pracownika() {
		return id_pracownika;
	}

	/**
	 * @param id_pracownika the id_pracownika to set
	 */
	public void setId_pracownika(int id_pracownika) {
		this.id_pracownika = id_pracownika;
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
	 * @return the plec
	 */
	public String getPlec() {
		return plec;
	}

	/**
	 * @param plec the plec to set
	 */
	public void setPlec(String plec) {
		this.plec = plec;
	}

	/**
	 * @return the dataUrodzenia
	 */
	public LocalDate getDataUrodzenia() {
		return data_urodzenia;
	}

	/**
	 * @param dataUrodzenia the dataUrodzenia to set
	 */
	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.data_urodzenia = dataUrodzenia;
	}

	/**
	 * @return the dataZatrudnienia
	 */
	public LocalDate getDataZatrudnienia() {
		return data_zatrudnienia;
	}

	/**
	 * @param dataZatrudnienia the dataZatrudnienia to set
	 */
	public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
		this.data_zatrudnienia = dataZatrudnienia;
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

	/**
	 * @return the stanowisko
	 */
	public String getStanowisko() {
		return stanowisko;
	}

	/**
	 * @param stanowisko the stanowisko to set
	 */
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	/**
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * @param opis the opis to set
	 */
	public void setOpis(String opis) {
		this.opis = opis;
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
	 * @return the nrKonta
	 */
	public String getNrKonta() {
		return nrKonta;
	}

	/**
	 * @param nrKonta the nrKonta to set
	 */
	public void setNrKonta(String nrKonta) {
		this.nrKonta = nrKonta;
	}

	/**
	 * @return the data_zwolnienia
	 */
	public LocalDate getData_zwolnienia() {
		return data_zwolnienia;
	}

	/**
	 * @param data_zwolnienia the data_zwolnienia to set
	 */
	public void setData_zwolnienia(LocalDate data_zwolnienia) {
		this.data_zwolnienia = data_zwolnienia;
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
	 * @return the id_adres
	 */
	public int getId_adres() {
		return id_adres;
	}

	/**
	 * @param id_adres the id_adres to set
	 */
	public void setId_adres(int id_adres) {
		this.id_adres = id_adres;
	}
	
	

}
