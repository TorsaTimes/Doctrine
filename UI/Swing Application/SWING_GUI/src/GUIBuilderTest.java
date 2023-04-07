

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
public class GUIBuilderTest {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="26,42"
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JLabel jLabel1 = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame("Otto");
			jFrame.setSize(new Dimension(526, 102));
			jFrame.setTitle("Otto");
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout(0, 2, 3, 3);
			gridLayout.setHgap(22);
			gridLayout.setVgap(11);
			jLabel1 = new JLabel();
			jLabel1.setText("Nachname");
			jLabel = new JLabel();
			jLabel.setText("Vorname");
			jLabel.setLocation(new Point(108, 54));
			jLabel.setSize(new Dimension(105, 41));
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(jLabel);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setText("Meier");
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("Otto");
		}
		return jTextField1;
	}

	

}
