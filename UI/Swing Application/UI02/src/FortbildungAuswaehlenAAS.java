import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class  FortbildungAuswaehlenAAS extends JComboBox {

	
	
	FortbildungAuswaehlenK kontrolle = new FortbildungAuswaehlenK();
	JComboBox auswahlBox;
	String auswahl;

	public FortbildungAuswaehlenAAS() {
		auswahlBox = new JComboBox(kontrolle.fortbildungen);
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

