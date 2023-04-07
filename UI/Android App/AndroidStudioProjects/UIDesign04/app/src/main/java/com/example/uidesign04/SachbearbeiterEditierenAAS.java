package com.example.uidesign04;

import android.app.Activity;



public class SachbearbeiterEditierenAAS extends SachbearbeiterS {























































	/*// --------------------------------Attribute der Klasse-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Klasse--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private JTextField textField;// Editieren Textfeld
	private JPasswordField passwortField;// Editieren Textfeld
	private JTextArea textArea;

	private JRadioButton radioButtonSachbearbeiter;// Editieren
	private JRadioButton radioButtonAdministrator;// Editieren

	radioButtonSachbearbeiter radioButtonSachbearbeiterEditierenListener = new radioButtonSachbearbeiter();
	radioButtonAdministrator radioButtonAdministratorEditierenListener = new radioButtonAdministrator();

	private JPanel adminEditierenPanel = new JPanel();
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static SachbearbeiterEditierenAAS instance;
	private static SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();

	// --------------------------------Instance der
	// Klasse-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static SachbearbeiterEditierenAAS getInstance() {
		if (instance == null) {
			instance = new SachbearbeiterEditierenAAS();
		}
		return instance;
	}
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------Create the
	// panel--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public SachbearbeiterEditierenAAS() {

		adminEditierenPanel.setLayout(null);
		adminEditierenPanel.setSize(600, 400);

		JLabel lblSachbearbeiterAdmin = new JLabel("Sachbearbeiter / Admin editieren");
		lblSachbearbeiterAdmin.setBounds(10, 11, 226, 14);
		adminEditierenPanel.add(lblSachbearbeiterAdmin);// 0

		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(10, 50, 137, 14);
		adminEditierenPanel.add(lblBenutzername);// 1

		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(10, 95, 127, 14);
		adminEditierenPanel.add(lblPasswort);// 2

		JLabel lblBerechtigung = new JLabel("Berechtigung");
		lblBerechtigung.setBounds(10, 143, 127, 14);
		adminEditierenPanel.add(lblBerechtigung);// 3

		JLabel lblFortbildungen = new JLabel("Fortbildungen");
		lblFortbildungen.setBounds(10, 200, 137, 14);
		adminEditierenPanel.add(lblFortbildungen);// 4

		JLabel lblSachbearbeiterAuswaehlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswaehlen.setBounds(10, 282, 170, 14);
		adminEditierenPanel.add(lblSachbearbeiterAuswaehlen);// 5

		textField = new JTextField();
		textField.setBounds(258, 47, 181, 20);
		adminEditierenPanel.add(textField);// 6
		textField.setColumns(10);

		passwortField = new JPasswordField();
		passwortField.setBounds(258, 92, 181, 20);
		passwortField.setColumns(10);
		adminEditierenPanel.add(passwortField);

		radioButtonSachbearbeiter = new JRadioButton("Sachbearbeiter");
		radioButtonSachbearbeiter.setBounds(258, 139, 181, 23);
		radioButtonSachbearbeiter.addActionListener(radioButtonSachbearbeiterEditierenListener);
		adminEditierenPanel.add(radioButtonSachbearbeiter);

		radioButtonAdministrator = new JRadioButton("Administrator");
		radioButtonAdministrator.setBounds(258, 165, 181, 23);
		radioButtonAdministrator.addActionListener(radioButtonAdministratorEditierenListener);
		adminEditierenPanel.add(radioButtonAdministrator);

		textArea = new JTextArea();
		textArea.setBounds(258, 195, 181, 71);
		adminEditierenPanel.add(textArea);
		textArea.setColumns(10);

		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(258, 279, 181, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
				textField.setText(sach.getBenutzername());
				passwortField.setText(sach.getPasswort());
				if (sach.gibBerechetigung() == "admin") {
					radioButtonAdministrator.setSelected(true);
					radioButtonSachbearbeiter.setSelected(false);

				} else {
					radioButtonSachbearbeiter.setSelected(true);
					radioButtonAdministrator.setSelected(false);

				}
				String text = sach.gibStringfuertextArea(name);
				textArea.setText(text);

			}
		});

		adminEditierenPanel.add(comboBox);

	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// ------------------------------------------------------Getter und Setter---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String getTextFieldBenutzer() {
		return textField.getText();
	}

	public String getPasswortFieldpasswort() {
		return passwortField.getText();
	}

	public JRadioButton getRadioButtonSachbearbeier() {
		return radioButtonSachbearbeiter;
	}

	public JRadioButton getRadioButtonAdministrator() {
		return radioButtonAdministrator;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JComboBox getComboBox() {
		return combo.oeffnen();
	}

	public JPanel sachbearbeiterEditieren(boolean editierbar) {
		return adminEditierenPanel;
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// --------------------------------RadioButton gegenseitig Ausschalten von
	// Sachbearbeiter
	// Editieren------------------------------------------------------
	class radioButtonSachbearbeiter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (radioButtonAdministrator.isSelected()) {
				radioButtonAdministrator.setSelected(false);
			}

		}
	}

	class radioButtonAdministrator implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (radioButtonSachbearbeiter.isSelected()) {
				radioButtonSachbearbeiter.setSelected(false);
			}

		}
	}*/
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
