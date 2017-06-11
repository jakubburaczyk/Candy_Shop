package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Adres;
import model.Cukiernia;
import model.Poczta;
import model.Pracownik;

public class JdbcConnection {

	/**
	 * Obiekt polaczenia z baza danych
	 */
	private Connection connection;
	
	/**
	 * Obiekt umozliwiajacy wysylanie zapytan do bazy danych i odbieranie od niej odpowiedzi
	 */
	private Statement statement;
	
	
	/**
	 * Konstruktor obiektu polaczenia z baza danych, wczytuje baze danych z pliku i ustanawia polaczenie z nia.
	 * Inicjalizuje zmienne umozliwiajace wysylanie do bazy danych zapytan.
	 */
	public JdbcConnection(String host, int port, String SID){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String adress = "jdbc:oracle:thin:@" + host + ":" + port + ":" + SID;
			String login = "jburaczy";
			String password = "jburaczy";
			connection = DriverManager.getConnection(adress, login, password);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
		}
	}
	
	/**
	 * Metoda sprawdzajaca podane login i haslo.
	 * @param login imie_nazwisko
	 * @param password pesel
	 * @return 0 jesli dopasowano wlasciciela, 1 jesli pracownika, -1 jesli nieprawidlowe dane
	 */
	public int checkLogin(String login, String password) {
		
		String imie = login.split("-")[0];
		String nazwisko = login.split("-")[1];
		
		PreparedStatement ps1 = null, ps2 = null;
		ResultSet rs1 = null, rs2 = null;
		
		try {
			String sql1 = "SELECT * FROM WLASCICIELE WHERE IMIE=? AND NAZWISKO=? AND PESEL=?";
			ps1 = connection.prepareStatement(sql1);
			
			ps1.setString(1, imie);
			ps1.setString(2, nazwisko);
			ps1.setString(3, password);
			
			rs1 = ps1.executeQuery();
			if (rs1.next()){
				return 0;
			}
			
			String sql2 = "SELECT * FROM PRACOWNICY WHERE IMIE=? AND NAZWISKO=? AND PESEL=?";
			ps2 = connection.prepareStatement(sql2);
			
			ps2.setString(1, imie);
			ps2.setString(2, nazwisko);
			ps2.setString(3, password);
			
			rs2 = ps2.executeQuery();
			if (rs2.next()){
				return 1;
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (ps1 != null) {
					ps1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
				if (rs2 != null) {
					rs2.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public Pracownik selectPracownik(String pesel){

		try {
			String sql1 = "SELECT PR.ID_PRACOWNIK, PR.IMIE, PR.NAZWISKO, PR.PLEC, PR.DATA_URODZENIA,"
					+ "PR.DATA_ZATRUDNIENIA, PR.PESEL, PR.STANOWISKO, PR.NUMER_KONTA, "
					+ "PR.NUMER_TELEFONU, PR.OPIS, PR.DATA_ZWOLNIENIA, PR.ID_CUKIERNI, PR.ID_ADRES, "
					+ "AD.MIASTO, AD.NAZWA_ULICY, AD.NUMER_BUDYNKU, AD.NUMER_LOKALU, AD.ID_POCZTA, "
					+ "AD.ID_DOSTAWCY, PO.KOD_POCZTOWY, PO.MIEJSCOWOSC "
					+ "FROM PRACOWNICY PR "
					+ "INNER JOIN ADRESY AD "
					+ "ON PR.ID_ADRES=AD.ID_ADRES "
					+ "INNER JOIN POCZTY PO "
					+ "ON AD.ID_POCZTA=PO.ID_POCZTA "
					+ "WHERE PR.PESEL=?";
			PreparedStatement ps1 = connection.prepareStatement(sql1);

			ps1.setString(1, pesel);

			ResultSet rs = ps1.executeQuery();
			if (rs.next()){
				Pracownik pracownik = new Pracownik();
				pracownik.setId_pracownika(rs.getInt(1));
				pracownik.setImie(rs.getString(2));
				pracownik.setNazwisko(rs.getString(3));
				pracownik.setPlec(rs.getString(4));
				pracownik.setDataUrodzenia(rs.getDate(5).toLocalDate());
				pracownik.setDataZatrudnienia(rs.getDate(6).toLocalDate());
				pracownik.setPesel(rs.getString(7));
				if (rs.getString(8) != null) pracownik.setStanowisko(rs.getString(8));
				if (rs.getString(9) != null) pracownik.setNrKonta(rs.getString(9));
				if (rs.getString(10) != null) pracownik.setNrTelefonu(rs.getString(10));
				if (rs.getString(11) != null) pracownik.setOpis(rs.getString(11));
				if (rs.getDate(12) != null) pracownik.setData_zwolnienia(rs.getDate(12).toLocalDate());
				pracownik.setId_cukierni(rs.getInt(13));
				pracownik.setId_adres(rs.getInt(14));

				Adres adres = new Adres();
				adres.setId_adres(rs.getInt(14));
				adres.setMiasto(rs.getString(15));
				adres.setNazwaUlicy(rs.getString(16));
				adres.setNumerBudynku(rs.getString(17));
				adres.setNumerLokalu(rs.getString(18));
				adres.setId_poczta(rs.getInt(19));
				adres.setId_cukierni(rs.getInt((13)));
				if (rs.getInt(20) != 0) adres.setId_dostawcy(rs.getInt(20));
				
				Poczta poczta = new Poczta();
				poczta.setId_poczta(rs.getInt(19));
				poczta.setKodPocztowy(rs.getString(21));
				poczta.setMiejscowosc(rs.getString(22));

				adres.setPoczta(poczta);
				pracownik.setAdres(adres);
				return pracownik;
			}
		} catch (SQLException e) {
			
		}
		
		return null;
	}
	
	public void updatePracownik(Pracownik pracownik){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRACOWNICY SET "
					+ "IMIE=?, NAZWISKO=?, PLEC=?, "
					+ "DATA_URODZENIA=?, DATA_ZATRUDNIENIA=?, PESEL=? "
					+ "WHERE ID_PRACOWNIK=?");
			
			preparedStatement.setString(1, pracownik.getImie());
			preparedStatement.setString(2, pracownik.getNazwisko());
			preparedStatement.setString(3, pracownik.getPlec());
			preparedStatement.setDate(4, Date.valueOf(pracownik.getDataUrodzenia()));
			preparedStatement.setDate(5, Date.valueOf(pracownik.getDataZatrudnienia()));
			preparedStatement.setString(6, pracownik.getPesel());
			preparedStatement.setInt(7, pracownik.getId_pracownika());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Cukiernia selectCukiernia(int id){
		try {
			String sql1 = "SELECT * FROM CUKIERNIE WHERE ID_CUKIERNI=?";
			PreparedStatement ps1 = connection.prepareStatement(sql1);

			ps1.setInt(1, id);

			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()){
				Cukiernia cukiernia = new Cukiernia();
				cukiernia.setIdCukierni(rs1.getInt(1));
				cukiernia.setNazwa(rs1.getString(2));
				cukiernia.setNip(rs1.getString(3));
				cukiernia.setRegon(rs1.getString(4));

				return cukiernia;
			}
			rs1.close();
			ps1.close();
		} catch (SQLException e) {

		}
		return null;
	}
	
	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * Metoda zamykajaca polaczenie z baza danych
	 */
	public void closeConnection(){
		try {
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
