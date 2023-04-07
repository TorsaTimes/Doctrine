package layoutManager;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class GridLayoutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLocationByPlatform(true);
		// new GridLayout(nRows, nCols, int hGap, int vGap)
		f.setLayout(new GridLayout(2,0,10,10));
		JPanel panel1 = getPanel(10,20,"1");
		JPanel panel2 = getPanel(20,40,"2");
		JPanel panel3 = getPanel(40,80,"3");
		JPanel panel4 = getPanel(80,160,"4");
		JPanel panel5 = getPanel(160,320,"5");
		JPanel panel6 = getPanel(320,640,"6");
		f.add(panel1);
		f.add(panel2);
		f.add(panel3);
		f.add(panel4);
		f.add(panel5);
		f.add(panel6);
//		f.setSize(400,300);
		f.pack();
		f.setVisible(true);


	}
	
	static JPanel getPanel(int width, int height, String text) {
		JPanel panel = new JPanel();
		panel.setBorder( new BevelBorder(BevelBorder.RAISED) );
		panel.setMaximumSize(new Dimension(width,height));
		panel.setMinimumSize(new Dimension(50,50));
		panel.setPreferredSize(new Dimension(width,height));
		panel.add(new JLabel(text));
		return panel;	
	}


}
