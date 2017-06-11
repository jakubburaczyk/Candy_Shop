package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Adres;
import model.Poczta;
import model.Pracownik;
import model.Wlasciciel;

public class JdbcWlasciciel {
	JdbcConnection jdbcConnection;
	
	public JdbcWlasciciel(JdbcConnection jdbcConnection){
		this.jdbcConnection = jdbcConnection;
	}
	
	public Wlasciciel selectWlasciciel(String pesel){
		Connection connection = jdbcConnection.getConnection();
		
		try {
			String sql1 = "SELECT * FROM WLASCICIELE WHERE PESEL=?";
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			
			ps1.setString(1, pesel);
			
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()){
				Wlasciciel wlasciciel = new Wlasciciel();
				wlasciciel.setId_wlasciciel(rs1.getInt(1));
				wlasciciel.setImie(rs1.getString(2));
				wlasciciel.setNazwisko(rs1.getString(3));
				wlasciciel.setOd_kiedy(rs1.getDate(4).toLocalDate());
				if (rs1.getDate(5) != null) wlasciciel.setDo_kiedy(rs1.getDate(5).toLocalDate());
				wlasciciel.setId_cukierni(rs1.getInt(6));
				wlasciciel.setPesel(rs1.getString(7));
				
				return wlasciciel;
			} 
			
		} catch (SQLException e){
		
		}
		return null;
	}
	
	public void updateWlasciciel(Wlasciciel wlasciciel){
		Connection connection = jdbcConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE WLASCICIELE SET "
					+ "IMIE=?, NAZWISKO=?, PESEL=?, OD_KIEDY=? WHERE ID_WLASCICIEL=?");
			
			preparedStatement.setString(1, wlasciciel.getImie());
			preparedStatement.setString(2, wlasciciel.getNazwisko());
			preparedStatement.setString(3, wlasciciel.getPesel());
			preparedStatement.setDate(4, Date.valueOf(wlasciciel.getOd_kiedy()));
			preparedStatement.setInt(5, wlasciciel.getId_wlasciciel());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void insertPoczta(Poczta poczta) {
		try {
			Connection connection = jdbcConnection.getConnection();
			
			PreparedStatement preparedStatement0 = connection.prepareStatement("select * from poczty where kod_pocztowy=?");
			preparedStatement0.setString(1, poczta.getKodPocztowy());
			
			ResultSet resultSet0 = preparedStatement0.executeQuery();
			if (resultSet0.next()){
				poczta.setId_poczta(resultSet0.getInt(1));
			} else {
				PreparedStatement preparedStatement1 = connection.prepareStatement("insert into poczty "
						+ "(kod_pocztowy, miejscowosc) "
						+ "values (?, ?)");

				preparedStatement1.setString(1, poczta.getKodPocztowy());
				preparedStatement1.setString(2, poczta.getMiejscowosc());

				preparedStatement1.executeUpdate();
				preparedStatement1.close();

				PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID_POCZTA FROM POCZTY "
						+ " WHERE KOD_POCZTOWY=? AND MIEJSCOWOSC=?");

				preparedStatement2.setString(1, poczta.getKodPocztowy());
				preparedStatement2.setString(2, poczta.getMiejscowosc());
				ResultSet resultSet1 = preparedStatement2.executeQuery();
				resultSet1.next();
				poczta.setId_poczta(resultSet1.getInt(1));
				preparedStatement2.close();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void updatePoczta(Poczta poczta){
		Connection connection = jdbcConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE POCZTY SET "
					+ "KOD_POCZTOWY=?, MIEJSCOWOSC=? "
					+ "WHERE ID_POCZTA=?");
			
			preparedStatement.setString(1, poczta.getKodPocztowy());
			preparedStatement.setString(2, poczta.getMiejscowosc());
			preparedStatement.setInt(3, poczta.getId_poczta());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}
	
	public void insertAdres(Adres adres) {
		try {
			
			insertPoczta(adres.getPoczta());
			
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement1 = connection.prepareStatement("insert into adresy "
					+ "(miasto, nazwa_ulicy, numer_lokalu, numer_budynku, id_poczta, id_cukierni) "
					+ "values (?, ?, ?, ?, ?, ?)");
			
			preparedStatement1.setString(1, adres.getMiasto());
			preparedStatement1.setString(2, adres.getNazwaUlicy());
			preparedStatement1.setString(3, adres.getNumerLokalu());
			preparedStatement1.setString(4, adres.getNumerBudynku());
			preparedStatement1.setInt(5, adres.getPoczta().getId_poczta());
			preparedStatement1.setInt(6, adres.getId_cukierni());
			
			System.out.println(adres.getPoczta().getId_poczta());
			
			preparedStatement1.executeUpdate();
			preparedStatement1.close();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID_ADRES FROM ADRESY "
					+ " WHERE nazwa_ulicy=? AND numer_lokalu=? AND numer_budynku=?");

			preparedStatement2.setString(1, adres.getNazwaUlicy());
			preparedStatement2.setString(2, adres.getNumerLokalu());
			preparedStatement2.setString(3, adres.getNumerBudynku());
			ResultSet resultSet = preparedStatement2.executeQuery();
			resultSet.next();
			adres.setId_adres(resultSet.getInt(1));
			preparedStatement2.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void updateAdres(Adres adres){
			Connection connection = jdbcConnection.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ADRESY SET "
						+ "MIASTO=?, NAZWA_ULICY=?, "
						+ "NUMER_LOKALU=?, NUMER_BUDYNKU=? "
						+ "WHERE ID_ADRES=?");
				
				preparedStatement.setString(1, adres.getMiasto());
				preparedStatement.setString(2, adres.getNazwaUlicy());
				preparedStatement.setString(1, adres.getNumerLokalu());
				preparedStatement.setString(2, adres.getNumerBudynku());
				preparedStatement.setInt(3, adres.getId_adres());
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 		
	}
	
	public void insertPracownik(Pracownik pracownik){
		try {
			insertAdres(pracownik.getAdres());
			
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRACOWNICY "
					+ " (IMIE, NAZWISKO, PLEC, DATA_URODZENIA, DATA_ZATRUDNIENIA, PESEL, ID_CUKIERNI, ID_ADRES) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, pracownik.getImie());
			preparedStatement.setString(2, pracownik.getNazwisko());
			preparedStatement.setString(3, pracownik.getPlec());
			preparedStatement.setDate(4, Date.valueOf(pracownik.getDataUrodzenia()));
			preparedStatement.setDate(5, Date.valueOf(pracownik.getDataZatrudnienia()));
			preparedStatement.setString(6, pracownik.getPesel());
			preparedStatement.setInt(7, 1);
			preparedStatement.setInt(8, pracownik.getAdres().getId_adres());

			preparedStatement.executeUpdate();
			preparedStatement.close();

			PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT ID_PRACOWNIK FROM PRACOWNICY "
					+ " WHERE PESEL=?");

			preparedStatement1.setString(1, pracownik.getPesel());

			ResultSet resultSet = preparedStatement1.executeQuery();
			resultSet.next();
			pracownik.setId_pracownika(resultSet.getInt(1));
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
	
	/*public void insertCukiernia(Cukiernia cukiernia){
		try {
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into cukiernie "
					+ "(Id_cukiernia, Nazwa, NIP, REGON) "
					+ "values (?,?,?,?)");
			
			preparedStatement.setInt(1, cukiernia.getIdCukierni());
			preparedStatement.setString(2, cukiernia.getNazwa());
			preparedStatement.setString(3, cukiernia.getNip());
			preparedStatement.setString(4, cukiernia.getRegon());
			preparedStatement.executeUpdate();
			preparedStatement.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
}
