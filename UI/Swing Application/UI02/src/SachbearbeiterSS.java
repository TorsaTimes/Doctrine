import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SachbearbeiterSS extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SachbearbeiterSS() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 1;
		add(lblLogin, gbc_lblLogin);
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.gridx = 1;
		gbc_lblBenutzername.gridy = 3;
		add(lblBenutzername, gbc_lblBenutzername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 5;
		add(lblPasswort, gbc_lblPasswort);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 8;
		gbc_passwordField.gridy = 5;
		add(passwordField, gbc_passwordField);
		
		JLabel lblBerechtigung = new JLabel("Berechtigung");
		GridBagConstraints gbc_lblBerechtigung = new GridBagConstraints();
		gbc_lblBerechtigung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBerechtigung.gridx = 1;
		gbc_lblBerechtigung.gridy = 7;
		add(lblBerechtigung, gbc_lblBerechtigung);
		
		JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
		GridBagConstraints gbc_rdbtnSachbearbeiter = new GridBagConstraints();
		gbc_rdbtnSachbearbeiter.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnSachbearbeiter.gridx = 8;
		gbc_rdbtnSachbearbeiter.gridy = 7;
		add(rdbtnSachbearbeiter, gbc_rdbtnSachbearbeiter);
		
		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		GridBagConstraints gbc_rdbtnAdministrator = new GridBagConstraints();
		gbc_rdbtnAdministrator.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAdministrator.gridx = 8;
		gbc_rdbtnAdministrator.gridy = 8;
		add(rdbtnAdministrator, gbc_rdbtnAdministrator);
		
		JButton btnBeenden = new JButton("Beenden");
		GridBagConstraints gbc_btnBeenden = new GridBagConstraints();
		gbc_btnBeenden.insets = new Insets(0, 0, 0, 5);
		gbc_btnBeenden.gridx = 1;
		gbc_btnBeenden.gridy = 10;
		add(btnBeenden, gbc_btnBeenden);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridwidth = 4;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 10;
		add(btnOk, gbc_btnOk);

	}

}
