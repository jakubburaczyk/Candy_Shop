package model;

public class Adres {
	private int id_adres;
	
	private String miasto;
	
	private String nazwaUlicy;
	
	private String numerLokalu;
	
	private String numerBudynku;
	
	private int id_poczta;
	
	private int id_cukierni;
	
	private int id_dostawcy;
	
	private Poczta poczta;
	
	

	/**
	 * @param id_adres
	 * @param miasto
	 * @param nazwaUlicy
	 * @param numerLokalu
	 * @param numerBudynku
	 * @param id_poczta
	 * @param id_cukierni
	 * @param id_dostawcy
	 */
//	public Adres(int id_adres, String miasto, String nazwaUlicy, String numerLokalu, String numerBudynku, int id_poczta,
//			int id_cukierni, int id_dostawcy) {
//		this.id_adres = id_adres;
//		this.miasto = miasto;
//		this.nazwaUlicy = nazwaUlicy;
//		this.numerLokalu = numerLokalu;
//		this.numerBudynku = numerBudynku;
//		this.id_poczta = id_poczta;
//		this.id_cukierni = id_cukierni;
//		this.id_dostawcy = id_dostawcy;
//	}
	
	/**
	 * Bezparametrowy konstruktor obiektu klasy adres
	 */
	public Adres(){
		super();
	}

	/**
	 * @return the poczta
	 */
	public Poczta getPoczta() {
		return poczta;
	}

	/**
	 * @param poczta the poczta to set
	 */
	public void setPoczta(Poczta poczta) {
		this.poczta = poczta;
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

	/**
	 * @return the miasto
	 */
	public String getMiasto() {
		return miasto;
	}

	/**
	 * @param miasto the miasto to set
	 */
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	/**
	 * @return the nazwaUlicy
	 */
	public String getNazwaUlicy() {
		return nazwaUlicy;
	}

	/**
	 * @param nazwaUlicy the nazwaUlicy to set
	 */
	public void setNazwaUlicy(String nazwaUlicy) {
		this.nazwaUlicy = nazwaUlicy;
	}

	/**
	 * @return the numerLokalu
	 */
	public String getNumerLokalu() {
		return numerLokalu;
	}

	/**
	 * @param numerLokalu the numerLokalu to set
	 */
	public void setNumerLokalu(String numerLokalu) {
		this.numerLokalu = numerLokalu;
	}

	/**
	 * @return the numerBudynku
	 */
	public String getNumerBudynku() {
		return numerBudynku;
	}

	/**
	 * @param numerBudynku the numerBudynku to set
	 */
	public void setNumerBudynku(String numerBudynku) {
		this.numerBudynku = numerBudynku;
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
	 * @return the id_dostawcy
	 */
	public int getId_dostawcy() {
		return id_dostawcy;
	}

	/**
	 * @param id_dostawcy the id_dostawcy to set
	 */
	public void setId_dostawcy(int id_dostawcy) {
		this.id_dostawcy = id_dostawcy;
	}
	
	
	
	
}
