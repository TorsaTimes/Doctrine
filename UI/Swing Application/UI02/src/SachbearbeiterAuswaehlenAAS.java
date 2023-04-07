import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class SachbearbeiterAuswaehlenAAS extends JComboBox {

	
	
	SachbearbeiterAuswaehlenK kontrolle = new SachbearbeiterAuswaehlenK();
	JComboBox auswahlBox;
	String auswahl;

	public SachbearbeiterAuswaehlenAAS() {
		auswahlBox = new JComboBox(kontrolle.namen);
		auswahlBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				auswahl = (String) auswahlBox.getSelectedItem();
			}
		});
		
	}
	
	public JComboBox oeffnen() {
		return auswahlBox;
	}
	
	public String getAuswahl() {
		System.out.println(auswahl);
		return auswahl;
	}
	
}

