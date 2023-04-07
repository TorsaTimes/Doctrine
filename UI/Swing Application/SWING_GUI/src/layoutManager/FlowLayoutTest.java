package layoutManager;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
public class FlowLayoutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLocationByPlatform(true);
		FlowLayout flowManager = new FlowLayout();
		flowManager.setHgap(100);
		flowManager.setAlignment(FlowLayout.LEFT);
		f.setLayout(flowManager);
		JPanel panel1 = new JPanel();
		panel1.setBorder( new BevelBorder(BevelBorder.RAISED) ); 
		JPanel panel2 = new JPanel();
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT); // wird von FlowLayout ignoriert !
		panel2.setBorder( new BevelBorder(BevelBorder.RAISED) ); 
		panel2.setAlignmentX(Component.RIGHT_ALIGNMENT); // wird von FlowLayout ignoriert !
		panel1.setPreferredSize(new Dimension(200,300));
		f.add(panel1);
		f.add(panel2);
//		f.pack();
		f.setSize(1000, 1000);
		f.setVisible(true);
	}

}
