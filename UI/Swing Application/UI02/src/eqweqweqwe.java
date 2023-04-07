import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class eqweqweqwe extends JPanel {

	/**
	 * Create the panel.
	 */
	public eqweqweqwe() {
		setLayout(null);
		
		JLabel lblFortbildungZuordnen = new JLabel("Fortbildung l\u00F6schen");
		lblFortbildungZuordnen.setBounds(23, 33, 129, 14);
		add(lblFortbildungZuordnen);
		
		JLabel lblAusgewhlterSachbearbeiter = new JLabel("Ausgew\u00E4hlter Sachbearbeiter");
		lblAusgewhlterSachbearbeiter.setBounds(23, 90, 189, 14);
		add(lblAusgewhlterSachbearbeiter);
		
		JLabel lblAusgewhlteFortbildung = new JLabel("Ausgew\u00E4hlte Fortbildung");
		lblAusgewhlteFortbildung.setBounds(222, 90, 205, 14);
		add(lblAusgewhlteFortbildung);
		
		JComboBox comboBoxFortbildung = new JComboBox();
		comboBoxFortbildung.setBounds(222, 115, 165, 20);
		add(comboBoxFortbildung);
		
		JComboBox ComboBoxSachbearbeiter = new JComboBox();
		ComboBoxSachbearbeiter.setBounds(23, 115, 148, 20);
		add(ComboBoxSachbearbeiter);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(23, 253, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(149, 253, 89, 23);
		add(btnNewButton_1);

	}
}
