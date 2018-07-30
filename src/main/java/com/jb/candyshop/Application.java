package com.jb.candyshop;

import java.time.LocalDate;

import javax.swing.SwingUtilities;

import com.jb.candyshop.jdbc.JdbcOwner;
import com.jb.candyshop.model.Address;
import com.jb.candyshop.model.Post;
import com.jb.candyshop.model.Worker;
import com.jb.candyshop.view.MainFrame;


public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();	
				mainFrame.setVisible(true);
				
//				JdbcConnection jdbcConnection = new JdbcConnection("ora3.elka.pw.edu.pl", 1521, "ora3inf");
//				Worker pracownik = jdbcConnection.selectPracownik("94050609715");
//				System.out.println(pracownik.getAddress().getProviderId());
//				jdbcConnection.closeConnection();
				
//				jdbcConnection.insertCukiernia(cukiernia);
//				jdbcConnection.insertPoczta2(new Post("02-596", "Bdg"));
//				Config.getConfig();
//				MainFrame mainFrame = new MainFrame();	
//				Controller ctrl = new Controller(mainFrame);
//				mainFrame.setController(ctrl);
//				mainFrame.setVisible(true);
			}
		});

    }
	
	
	public static void insertWorker(JdbcOwner jdbc) {
		Post post = new Post();
		post.setPostCode("07-123");
		post.setTown("Puck");
		
		Address address = new Address();
		address.setTown("Puck");
		address.setStreet("Morska");
		address.setBuildingNumber("11");
		address.setApartamentNumber("13");
		address.setPost(post);
		address.setCandySchopId(1);
		
		Worker worker = new Worker();
		worker.setForName("Adam");
		worker.setLatsName("Nowak");
		worker.setPesel("94050609715");
		worker.setGender("M");
		worker.setAddress(address);
		worker.setDayOfBirth(LocalDate.of(1965, 5, 6));
		worker.setDateOfEmployment(LocalDate.of(2010, 5, 1));
		worker.setCandyShopId(1);

		jdbc.insertPracownik(worker);
	}
}
