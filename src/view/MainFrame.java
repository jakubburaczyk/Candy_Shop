package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
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
	private JMenuItem jMenuItem;
	private JPanel dataPanel;
	private JPanel examinationPanel;
	private JPanel patientsTablePanel;
	private JButton addPatientBtn;
	private JButton removePatientButton;
	private JButton savePatientButton;
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
//		createMenu();
		JPanel cards = new JPanel(new CardLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.insets = new Insets(2,2,2,2);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.LINE_START;
		dataPanel = new JPanel(new GridBagLayout());
		createIntroPanel(dataPanel);
		add(dataPanel, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		examinationPanel = new JPanel(new GridBagLayout());
		createExaminationPanel(examinationPanel);

		add(examinationPanel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 3;
		c.anchor = GridBagConstraints.CENTER;
		patientsTablePanel = new JPanel(new BorderLayout());
//		createPatientsTablePanel(patientsTablePanel);

		add(patientsTablePanel, c);
	}

	/*public void createMenu(){
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Aplikacja");
		jMenuItem = new JMenuItem("Zakoncz");
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK);
		jMenuItem.setAccelerator(key);
		jMenu.add(jMenuItem);
		jMenuBar.add(jMenu);
		setJMenuBar(jMenuBar);
	}*/


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

		JLabel hostLabel = new JLabel("Adres hosta:");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		introPanel.add(hostLabel, c);
		
		hostField = new JTextField(fieldSize);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		introPanel.add(hostField, c);
		femaleRadio = new JRadioButton("Kobieta");
		femaleRadio.setActionCommand("K");
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		introPanel.add(femaleRadio, c);
		maleRadio = new JRadioButton("Mezczyzna");
		maleRadio.setActionCommand("M");
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		introPanel.add(maleRadio, c);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(femaleRadio);
		buttonGroup.add(maleRadio);

		JLabel insuranceLabel = new JLabel("Ubezpieczenie:");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		introPanel.add(insuranceLabel, c);

		insuranceBox = new JComboBox<String>();
		insuranceBox.addItem("NFZ");
		insuranceBox.addItem("Prywatne");
		insuranceBox.addItem("Brak");
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		introPanel.add(insuranceBox, c);
		
		savePatientButton = new JButton("Zapisz");
		c.insets = new Insets(15, 10, 5, 10);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		introPanel.add(savePatientButton, c);
		
		discardPatientButton = new JButton("Anuluj");
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		introPanel.add(discardPatientButton, c);
		
		introPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), 
				"Dane pacjenta"));
	}

	public void createExaminationPanel(JPanel examinationPanel){
		int fieldSize = 0;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		
		c.insets = new Insets(0, 5, 0, 5);

		JLabel dataLabel = new JLabel("Data:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		examinationPanel.add(dataLabel, c);

		JLabel p1Label = new JLabel("Liczba erytrocytow [mln/mm3]:");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		examinationPanel.add(p1Label, c);

		redCellsField = new JTextField(fieldSize);
		//c.weightx = 0;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		examinationPanel.add(redCellsField, c);

		JLabel p2Label = new JLabel("Stezenie hemoglobiny [g/dl]:");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		examinationPanel.add(p2Label, c);

		hemoglobinField = new JTextField(fieldSize);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		examinationPanel.add(hemoglobinField, c);

		JLabel p3Label = new JLabel("Stezenie zelaza [mg/dl]:");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		examinationPanel.add(p3Label, c);	

		ironField = new JTextField(fieldSize);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		examinationPanel.add(ironField, c);
		
		saveExaminationButton = new JButton("Zapisz");
		c.insets = new Insets(10, 10, 0, 10);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		examinationPanel.add(saveExaminationButton, c);
		
		discardExaminationButton = new JButton("Anuluj");
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		examinationPanel.add(discardExaminationButton, c);

		examinationPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), 
				"Badanie"));
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

	public void clearExaminationPanel()
	{
		redCellsField.setText("");
		hemoglobinField.setText("");
		ironField.setText("");
	}

	public void invalidSignMessageWindow()
	{
		JOptionPane.showMessageDialog(this, "Wpisano błędny znak, podaj liczbe!", "Uwaga!", JOptionPane.ERROR_MESSAGE);
	}



	public void setController(EventListener a) 
	{
		this.jMenuItem.setActionCommand("menu-zakoncz");
		this.addPatientBtn.setActionCommand("add-patient-button");
		this.removePatientButton.setActionCommand("remove-patient-button");
		this.savePatientButton.setActionCommand("save-patient-button");
		this.discardPatientButton.setActionCommand("discard-patient-button");
		this.saveExaminationButton.setActionCommand("save-examination-button");
		this.discardExaminationButton.setActionCommand("discard-examination-button");
		this.peselField.getDocument().putProperty("name", "pesel-field");
		this.redCellsField.getDocument().putProperty("name", "red-cells-field");
		this.hemoglobinField.getDocument().putProperty("name", "hemoglobin-field");
		this.ironField.getDocument().putProperty("name", "iron-field");

		this.addWindowListener((WindowListener) a);
		this.jMenuItem.addActionListener((ActionListener) a);
		this.addPatientBtn.addActionListener((ActionListener) a);
		this.removePatientButton.addActionListener((ActionListener) a);
		this.savePatientButton.addActionListener((ActionListener) a);
		this.discardPatientButton.addActionListener((ActionListener) a);
		this.saveExaminationButton.addActionListener((ActionListener) a);
		this.discardExaminationButton.addActionListener((ActionListener) a);
		this.addComponentListener((ComponentListener) a);
		this.cellSelectionModel.addListSelectionListener((ListSelectionListener) a);
		this.peselField.getDocument().addDocumentListener((DocumentListener) a);
		this.redCellsField.getDocument().addDocumentListener((DocumentListener) a);
		this.hemoglobinField.getDocument().addDocumentListener((DocumentListener) a);
		this.ironField.getDocument().addDocumentListener((DocumentListener) a);
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
