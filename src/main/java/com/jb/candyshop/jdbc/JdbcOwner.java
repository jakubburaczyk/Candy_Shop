package com.jb.candyshop.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jb.candyshop.model.Address;
import com.jb.candyshop.model.Post;
import com.jb.candyshop.model.Worker;
import com.jb.candyshop.model.Owner;

public class JdbcOwner {

	private JdbcConnection jdbcConnection;
	
	public JdbcOwner(JdbcConnection jdbcConnection){
		this.jdbcConnection = jdbcConnection;
	}
	
	public Owner selectOwner(String id){
		Connection connection = jdbcConnection.getConnection();
		
		try {
			String sql1 = "SELECT * FROM WLASCICIELE WHERE PESEL=?";
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			
			ps1.setString(1, id);
			
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()){
				Owner owner = new Owner();
				owner.setOwnerId(rs1.getInt(1));
				owner.setForName(rs1.getString(2));
				owner.setLastName(rs1.getString(3));
				owner.setSinceWhen(rs1.getDate(4).toLocalDate());
				if (rs1.getDate(5) != null) owner.setToWhen(rs1.getDate(5).toLocalDate());
				owner.setCandyShopId(rs1.getInt(6));
				owner.setId(rs1.getString(7));
				
				return owner;
			} 
			
		} catch (SQLException e){
		
		}
		return null;
	}
	
	public void updateOwner(Owner owner){
		Connection connection = jdbcConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE WLASCICIELE SET "
					+ "IMIE=?, NAZWISKO=?, PESEL=?, OD_KIEDY=? WHERE ID_WLASCICIEL=?");
			
			preparedStatement.setString(1, owner.getForName());
			preparedStatement.setString(2, owner.getLastName());
			preparedStatement.setString(3, owner.getId());
			preparedStatement.setDate(4, Date.valueOf(owner.getSinceWhen()));
			preparedStatement.setInt(5, owner.getOwnerId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	private void insertPost(Post post) {
		try {
			Connection connection = jdbcConnection.getConnection();
			
			PreparedStatement preparedStatement0 = connection.prepareStatement("select * from poczty where kod_pocztowy=?");
			preparedStatement0.setString(1, post.getPostCode());
			
			ResultSet resultSet0 = preparedStatement0.executeQuery();
			if (resultSet0.next()){
				post.setPostId(resultSet0.getInt(1));
			} else {
				PreparedStatement preparedStatement1 = connection.prepareStatement("insert into poczty "
						+ "(kod_pocztowy, miejscowosc) "
						+ "values (?, ?)");

				preparedStatement1.setString(1, post.getPostCode());
				preparedStatement1.setString(2, post.getTown());

				preparedStatement1.executeUpdate();
				preparedStatement1.close();

				PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID_POCZTA FROM POCZTY "
						+ " WHERE KOD_POCZTOWY=? AND MIEJSCOWOSC=?");

				preparedStatement2.setString(1, post.getPostCode());
				preparedStatement2.setString(2, post.getTown());
				ResultSet resultSet1 = preparedStatement2.executeQuery();
				resultSet1.next();
				post.setPostId(resultSet1.getInt(1));
				preparedStatement2.close();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void updatePoczta(Post post){
		Connection connection = jdbcConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE POCZTY SET "
					+ "KOD_POCZTOWY=?, MIEJSCOWOSC=? "
					+ "WHERE ID_POCZTA=?");
			
			preparedStatement.setString(1, post.getPostCode());
			preparedStatement.setString(2, post.getTown());
			preparedStatement.setInt(3, post.getPostId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}
	
	public void insertAdres(Address address) {
		try {
			
			insertPost(address.getPost());
			
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement1 = connection.prepareStatement("insert into adresy "
					+ "(miasto, nazwa_ulicy, numer_lokalu, numer_budynku, id_poczta, id_cukierni) "
					+ "values (?, ?, ?, ?, ?, ?)");
			
			preparedStatement1.setString(1, address.getTown());
			preparedStatement1.setString(2, address.getStreet());
			preparedStatement1.setString(3, address.getApartamentNumber());
			preparedStatement1.setString(4, address.getBuildingNumber());
			preparedStatement1.setInt(5, address.getPost().getPostId());
			preparedStatement1.setInt(6, address.getCandySchopId());
			
			System.out.println(address.getPost().getPostId());
			
			preparedStatement1.executeUpdate();
			preparedStatement1.close();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID_ADRES FROM ADRESY "
					+ " WHERE nazwa_ulicy=? AND numer_lokalu=? AND numer_budynku=?");

			preparedStatement2.setString(1, address.getStreet());
			preparedStatement2.setString(2, address.getApartamentNumber());
			preparedStatement2.setString(3, address.getBuildingNumber());
			ResultSet resultSet = preparedStatement2.executeQuery();
			resultSet.next();
			address.setAddressId(resultSet.getInt(1));
			preparedStatement2.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void updateAdres(Address address){
			Connection connection = jdbcConnection.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ADRESY SET "
						+ "MIASTO=?, NAZWA_ULICY=?, "
						+ "NUMER_LOKALU=?, NUMER_BUDYNKU=? "
						+ "WHERE ID_ADRES=?");
				
				preparedStatement.setString(1, address.getTown());
				preparedStatement.setString(2, address.getStreet());
				preparedStatement.setString(1, address.getApartamentNumber());
				preparedStatement.setString(2, address.getBuildingNumber());
				preparedStatement.setInt(3, address.getAddressId());
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 		
	}
	
	public void insertPracownik(Worker worker){
		try {
			insertAdres(worker.getAddress());
			
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRACOWNICY "
					+ " (IMIE, NAZWISKO, PLEC, DATA_URODZENIA, DATA_ZATRUDNIENIA, PESEL, ID_CUKIERNI, ID_ADRES) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, worker.getForName());
			preparedStatement.setString(2, worker.getLatsName());
			preparedStatement.setString(3, worker.getGender());
			preparedStatement.setDate(4, Date.valueOf(worker.getDayOfBirth()));
			preparedStatement.setDate(5, Date.valueOf(worker.getDateOfEmployment()));
			preparedStatement.setString(6, worker.getPesel());
			preparedStatement.setInt(7, 1);
			preparedStatement.setInt(8, worker.getAddress().getAddressId());

			preparedStatement.executeUpdate();
			preparedStatement.close();

			PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT ID_PRACOWNIK FROM PRACOWNICY "
					+ " WHERE PESEL=?");

			preparedStatement1.setString(1, worker.getPesel());

			ResultSet resultSet = preparedStatement1.executeQuery();
			resultSet.next();
			worker.setWorkerId(resultSet.getInt(1));
			preparedStatement1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda usuwajaca tabele z bazy danych
	 * @param tableName
	 */
	public void dropTable(String tableName) {
		try {
			Connection connection = jdbcConnection.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE " + tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public void insertCukiernia(CandyShop cukiernia){
		try {
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into cukiernie "
					+ "(Id_cukiernia, Nazwa, NIP, REGON) "
					+ "values (?,?,?,?)");
			
			preparedStatement.setInt(1, cukiernia.getIdCukierni());
			preparedStatement.setString(2, cukiernia.getName());
			preparedStatement.setString(3, cukiernia.getNip());
			preparedStatement.setString(4, cukiernia.getRegon());
			preparedStatement.executeUpdate();
			preparedStatement.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
}
