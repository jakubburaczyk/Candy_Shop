package com.jb.candyshop.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jb.candyshop.model.Address;
import com.jb.candyshop.model.CandyShop;
import com.jb.candyshop.model.Post;
import com.jb.candyshop.model.Worker;

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
			String adress = "com.jb.candyshop.jdbc:oracle:thin:@" + host + ":" + port + ":" + SID;
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
	
	public Worker selectPracownik(String pesel){

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
				Worker worker = new Worker();
				worker.setWorkerId(rs.getInt(1));
				worker.setForName(rs.getString(2));
				worker.setLatsName(rs.getString(3));
				worker.setGender(rs.getString(4));
				worker.setDayOfBirth(rs.getDate(5).toLocalDate());
				worker.setDateOfEmployment(rs.getDate(6).toLocalDate());
				worker.setPesel(rs.getString(7));
				if (rs.getString(8) != null) worker.setJob(rs.getString(8));
				if (rs.getString(9) != null) worker.setAccount(rs.getString(9));
				if (rs.getString(10) != null) worker.setTelephone(rs.getString(10));
				if (rs.getString(11) != null) worker.setDesc(rs.getString(11));
				if (rs.getDate(12) != null) worker.setDateOfUnemployment(rs.getDate(12).toLocalDate());
				worker.setCandyShopId(rs.getInt(13));
				worker.setAddressId(rs.getInt(14));

				Address address = new Address();
				address.setAddressId(rs.getInt(14));
				address.setTown(rs.getString(15));
				address.setStreet(rs.getString(16));
				address.setBuildingNumber(rs.getString(17));
				address.setApartamentNumber(rs.getString(18));
				address.setPostId(rs.getInt(19));
				address.setCandySchopId(rs.getInt((13)));
				if (rs.getInt(20) != 0) address.setProviderId(rs.getInt(20));
				
				Post post = new Post();
				post.setPostId(rs.getInt(19));
				post.setPostCode(rs.getString(21));
				post.setTown(rs.getString(22));

				address.setPost(post);
				worker.setAddress(address);
				return worker;
			}
		} catch (SQLException e) {
			
		}
		
		return null;
	}
	
	public void updatePracownik(Worker worker){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRACOWNICY SET "
					+ "IMIE=?, NAZWISKO=?, PLEC=?, "
					+ "DATA_URODZENIA=?, DATA_ZATRUDNIENIA=?, PESEL=? "
					+ "WHERE ID_PRACOWNIK=?");
			
			preparedStatement.setString(1, worker.getForName());
			preparedStatement.setString(2, worker.getLatsName());
			preparedStatement.setString(3, worker.getGender());
			preparedStatement.setDate(4, Date.valueOf(worker.getDayOfBirth()));
			preparedStatement.setDate(5, Date.valueOf(worker.getDateOfEmployment()));
			preparedStatement.setString(6, worker.getPesel());
			preparedStatement.setInt(7, worker.getWorkerId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CandyShop selectCukiernia(int id){
		try {
			String sql1 = "SELECT * FROM CUKIERNIE WHERE ID_CUKIERNI=?";
			PreparedStatement ps1 = connection.prepareStatement(sql1);

			ps1.setInt(1, id);

			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()){
				CandyShop candyShop = new CandyShop();
				candyShop.setCandyShopId(rs1.getInt(1));
				candyShop.setName(rs1.getString(2));
				candyShop.setNip(rs1.getString(3));
				candyShop.setRegon(rs1.getString(4));

				return candyShop;
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
