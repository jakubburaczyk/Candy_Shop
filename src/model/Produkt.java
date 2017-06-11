package model;

public class Produkt {

	private int id_produktu;
	
	private String nazwa;
	
	private double kosztProdukcji;
	
	private double cenaBrutto;
	
	private int vat;
	
	private int waga;
	
	/**
	 * Bezparametrowy konstruktor obiektu klasy produkt
	 */
	public Produkt(){
		super();
	}

	/**
	 * @param id_produktu
	 * @param nazwa
	 * @param kosztProdukcji
	 * @param cenaBrutto
	 * @param vat
	 * @param waga
	 */
//	public Produkt(int id_produktu, String nazwa, double kosztProdukcji, double cenaBrutto, int vat, int waga) {
//		this.id_produktu = id_produktu;
//		this.nazwa = nazwa;
//		this.kosztProdukcji = kosztProdukcji;
//		this.cenaBrutto = cenaBrutto;
//		this.vat = vat;
//		this.waga = waga;
//	}

	/**
	 * @return the id_produktu
	 */
	public int getId_produktu() {
		return id_produktu;
	}

	/**
	 * @param id_produktu the id_produktu to set
	 */
	public void setId_produktu(int id_produktu) {
		this.id_produktu = id_produktu;
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
	 * @return the kosztProdukcji
	 */
	public double getKosztProdukcji() {
		return kosztProdukcji;
	}

	/**
	 * @param kosztProdukcji the kosztProdukcji to set
	 */
	public void setKosztProdukcji(double kosztProdukcji) {
		this.kosztProdukcji = kosztProdukcji;
	}

	/**
	 * @return the cenaBrutto
	 */
	public double getCenaBrutto() {
		return cenaBrutto;
	}

	/**
	 * @param cenaBrutto the cenaBrutto to set
	 */
	public void setCenaBrutto(double cenaBrutto) {
		this.cenaBrutto = cenaBrutto;
	}

	/**
	 * @return the vat
	 */
	public int getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(int vat) {
		this.vat = vat;
	}

	/**
	 * @return the waga
	 */
	public int getWaga() {
		return waga;
	}

	/**
	 * @param waga the waga to set
	 */
	public void setWaga(int waga) {
		this.waga = waga;
	}
	
	
	
	
}
