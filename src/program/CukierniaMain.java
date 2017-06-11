package program;

import java.time.LocalDate;

import javax.swing.SwingUtilities;

import jdbc.JdbcConnection;
import jdbc.JdbcWlasciciel;
import model.Adres;
import model.Poczta;
import model.Pracownik;
import model.Wlasciciel;
import view.MainFrame;


public class CukierniaMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();	
				mainFrame.setVisible(true);
				
//				JdbcConnection jdbcConnection = new JdbcConnection("ora3.elka.pw.edu.pl", 1521, "ora3inf");
//				Pracownik pracownik = jdbcConnection.selectPracownik("94050609715");
//				System.out.println(pracownik.getAdres().getId_dostawcy());
//				jdbcConnection.closeConnection();
				
//				jdbcConnection.insertCukiernia(cukiernia);
//				jdbcConnection.insertPoczta2(new Poczta("02-596", "Bdg"));
//				Config.getConfig();
//				MainFrame mainFrame = new MainFrame();	
//				Controller ctrl = new Controller(mainFrame);
//				mainFrame.setController(ctrl);
//				mainFrame.setVisible(true);
			}
		});

    }
	
	
	public static void insertPracownik(JdbcWlasciciel jdbc) {
		Poczta poczta = new Poczta();
		poczta.setKodPocztowy("07-123");
		poczta.setMiejscowosc("Puck");
		
		Adres adres = new Adres();
		adres.setMiasto("Puck");
		adres.setNazwaUlicy("Morska");
		adres.setNumerBudynku("11");
		adres.setNumerLokalu("13");
		adres.setPoczta(poczta);
		adres.setId_cukierni(1);
		
		Pracownik pracownik = new Pracownik();
		pracownik.setImie("Adam");
		pracownik.setNazwisko("Nowak");
		pracownik.setPesel("94050609715");
		pracownik.setPlec("M");
		pracownik.setAdres(adres);
		pracownik.setDataUrodzenia(LocalDate.of(1965, 5, 6));
		pracownik.setDataZatrudnienia(LocalDate.of(2010, 5, 1));
		pracownik.setId_cukierni(1);
		
		
		jdbc.insertPracownik(pracownik);
	}
}
