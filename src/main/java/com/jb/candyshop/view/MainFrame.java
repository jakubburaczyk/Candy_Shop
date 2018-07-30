package com.jb.candyshop.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JTextField loginField;
	private JTextField passField;
	private JTextField peselField;
	private ButtonGroup buttonGroup;
	private JComboBox<String> insuranceBox;
	private JRadioButton femaleRadio;
	private JRadioButton maleRadio;



	private MyTableModel myTableModel;
	private ListSelectionModel cellSelectionModel;
	private JTable jTable;
	private JMenuItem menuRefresh;
	private JMenuItem menuExit;
	private JPanel introPanel;
	private JPanel examinationPanel;
	private JPanel patientsTablePanel;
	private JButton addPatientBtn;
	private JButton removePatientButton;
	private JButton loginButton;
	private JButton discardPatientButton;
	private JButton saveExaminationButton;
	private JButton discardExaminationButton;
	private JTextField hostField;


	public MainFrame() {
		super("Rejestracja wynikow badan");
		initialCnfiguration();
		createGUI();
	}

	public void initialCnfiguration() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
	}

	public void createGUI() {
		createMenu();
//		JPanel cards = new JPanel(new CardLayout());
		JTabbedPane cards = new JTabbedPane();
		
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		c.weightx = 1.0;
//		c.weighty = 1.0;
//		c.insets = new Insets(2,2,2,2);
//		
//		c.gridx = 0;
//		c.gridy = 0;
//		c.gridwidth = 1;
//		c.gridheight = 2;
//		c.anchor = GridBagConstraints.LINE_START;
		introPanel = new JPanel(new GridBagLayout());
		createIntroPanel(introPanel);
		
		JComponent panel2 = makeTextPanel("Panel #2");
		JComponent panel3 = makeTextPanel("Panel #3");
		
		cards.addTab("Login", introPanel);
		cards.addTab("Dane pracownika", panel2);
		cards.addTab("Dane cukierni", panel3);
//		cards.add(introPanel, "Login");
//		cards.add(introPanel, "Dane");
		this.add(cards);
//
//		c.gridx = 0;
//		c.gridy = 2;
//		c.gridwidth = 1;
//		c.gridheight = 1;
//		c.anchor = GridBagConstraints.LAST_LINE_START;
//		examinationPanel = new JPanel(new GridBagLayout());
//		createExaminationPanel(examinationPanel);
//
//		add(examinationPanel, c);
//
//		c.gridx = 1;
//		c.gridy = 0;
//		c.gridwidth = 2;
//		c.gridheight = 3;
//		c.anchor = GridBagConstraints.CENTER;
//		patientsTablePanel = new JPanel(new BorderLayout());
////		createPatientsTablePanel(patientsTablePanel);
//
//		add(patientsTablePanel, c);
	}

	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

	public void createMenu(){
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Aplikacja");
		menuRefresh = new JMenuItem("Zakoncz");
		menuExit = new JMenuItem("Zakoncz");
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK);
		menuExit.setAccelerator(key);
		jMenu.add(menuRefresh);
		jMenu.add(menuExit);
		jMenuBar.add(jMenu);
		this.setJMenuBar(jMenuBar);
	}


	public void createIntroPanel(JPanel introPanel){
		int fieldSize = 10;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.insets = new Insets(0,5,0,5);

		JLabel forenameLabel = new JLabel("Login:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		introPanel.add(forenameLabel, c);

		loginField = new JTextField(fieldSize);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		introPanel.add(loginField, c);

		JLabel passLabel = new JLabel("Haslo:");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		introPanel.add(passLabel, c);

		passField = new JPasswordField(fieldSize);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		introPanel.add(passField, c);

		JLabel sidLabel = new JLabel("SID:");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		introPanel.add(sidLabel, c);

		peselField = new JTextField(fieldSize);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		introPanel.add(peselField, c);

		JLabel hostLabel = new JLabel("Address hosta:");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		introPanel.add(hostLabel, c);
		
		hostField = new JTextField(fieldSize);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		introPanel.add(hostField, c);
		
		
		loginButton = new JButton("Zaloguj");
		c.insets = new Insets(15, 10, 5, 10);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		introPanel.add(loginButton, c);
		
		discardPatientButton = new JButton("Anuluj");
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		introPanel.add(discardPatientButton, c);
		
		introPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), 
				"Dane pacjenta"));
	}

	

	public boolean isDataChanged() {
		if (loginField.getText().equals("") || passField.getText().equals("") ||
				peselField.getText().equals("") || (!maleRadio.isSelected() && !femaleRadio.isSelected()))
		{
			return false;
		}
		return true;
	}

	public void clearDataPanel() 
	{
		passField.setText("");
		loginField.setText("");
		peselField.setText("");
		buttonGroup.clearSelection();
		insuranceBox.setSelectedIndex(0);
	}


	public void invalidSignMessageWindow()
	{
		JOptionPane.showMessageDialog(this, "Wpisano błędny znak, podaj liczbe!", "Uwaga!", JOptionPane.ERROR_MESSAGE);
	}



	public void setController(EventListener eventListener) 
	{
		this.menuExit.setActionCommand("menu-zakoncz");
		this.addPatientBtn.setActionCommand("add-patient-button");
		this.removePatientButton.setActionCommand("remove-patient-button");
	}


	/**
	 * Zagniezdzona klasa rozszerzajaca mozliwosci DefaultTableModel o wyswietlanie 
	 * jednej z kolumn jako checkbox oraz zablokowanie mozliwosci recznej edycji zawartosci wszystkich komorek
	 * @author 
	 */
	class MyTableModel extends DefaultTableModel
	{
		public MyTableModel(Object[] columnNames, int i) 
		{
			super(columnNames, i);
		}

		public Class<?> getColumnClass(int columnIndex) 
		{
			return getValueAt(0, columnIndex).getClass();
		}

		public boolean isCellEditable(int row, int col) 
		{
			return false;
		}
	}

}
