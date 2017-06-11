package model;

public class Poczta {
	private int id_poczta;
	
	private String kodPocztowy;
	
	private String miejscowosc;
	
	/**
	 * Bezparametrowy konstruktor obiektu klasy poczta
	 */
	public Poczta(){
		super();
	}

	/**
	 * @param id_poczta
	 * @param kodPocztowy
	 * @param miejscowosc
	 */
	public Poczta(int id_poczta, String kodPocztowy, String miejscowosc) {
		this.id_poczta = id_poczta;
		this.kodPocztowy = kodPocztowy;
		this.miejscowosc = miejscowosc;
	}
	
	/**
	 * @param kodPocztowy
	 * @param miejscowosc
	 */
	public Poczta(String kodPocztowy, String miejscowosc) {
		this.kodPocztowy = kodPocztowy;
		this.miejscowosc = miejscowosc;
	}


	/**
	 * @return the id_poczta
	 */
	public int getId_poczta() {
		return id_poczta;
	}

	/**
	 * @param id_poczta the id_poczta to set
	 */
	public void setId_poczta(int id_poczta) {
		this.id_poczta = id_poczta;
	}

	/**
	 * @return the kodPocztowy
	 */
	public String getKodPocztowy() {
		return kodPocztowy;
	}

	/**
	 * @param kodPocztowy the kodPocztowy to set
	 */
	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	/**
	 * @return the miejscowosc
	 */
	public String getMiejscowosc() {
		return miejscowosc;
	}

	/**
	 * @param miejscowosc the miejscowosc to set
	 */
	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	
	
}
