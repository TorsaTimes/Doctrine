package layoutManager;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GridBagLayoutTest2 {
	static JButton getButton(String aufschrift) {
		JButton knopf = new JButton(aufschrift);
		knopf.setPreferredSize(new Dimension(150,150));
		knopf.setMinimumSize(new Dimension(100, 100));
		knopf.setMaximumSize(new Dimension(200,200));
		System.out.println(knopf.getMinimumSize());
		return knopf;
	}
	public static void main(String[] args) {
		JFrame rahmen = new JFrame("GridBagLayoutTest2");
		JTextArea ta = new JTextArea();
		rahmen.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.gridx = 0;
		constraints1.gridy = 0;
//		constraints1.ipadx = 50;
//		constraints1.ipady = 50;
		constraints1.fill = GridBagConstraints.VERTICAL; 
//		constraints1.insets = new Insets(50, 50, 50, 50); // (oben, links, unten,rechts)
//		constraints1.weightx = .1;
		constraints1.weighty = .1;
		constraints1.anchor = GridBagConstraints.FIRST_LINE_START;
		rahmen.getContentPane().add(getButton("1"), constraints1);


		GridBagConstraints constraints2 = new GridBagConstraints();
//		constraints2.fill = GridBagConstraints.NONE; 
		constraints2.gridx = 1;
		constraints2.gridy = 1;
//		constraints2.weightx = .1;
		constraints2.weighty = .0;
//		constraints2.anchor = GridBagConstraints.LAST_LINE_END;
//		constraints2.fill = GridBagConstraints.HORIZONTAL;
		rahmen.getContentPane().add(getButton("2"), constraints2);

		
		
		rahmen.pack();
		rahmen.setVisible(true);
		
	}

}
