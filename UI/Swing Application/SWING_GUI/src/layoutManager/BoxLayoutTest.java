package layoutManager;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.Dimension;

public class BoxLayoutTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JButton jButton2 = null;
	private final float X_ALIGNEMENT = JComponent.CENTER_ALIGNMENT;

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton("Button 1");
			// jButton.setText("Knopf1");
			jButton.setMinimumSize(new Dimension(120, 60));
			jButton.setPreferredSize(new Dimension(160, 100));
			jButton.setMaximumSize(new Dimension(180, 140));

			jButton.setAlignmentX(this.X_ALIGNEMENT);
		}
		return jButton;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton("Button 2");
			jButton2.setMinimumSize(new Dimension(120, 60));
			jButton2.setPreferredSize(new Dimension(160, 100));
			jButton2.setMaximumSize(new Dimension(200, 140));

			jButton2.setAlignmentX(this.X_ALIGNEMENT);
		}
		return jButton2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BoxLayoutTest frame = new BoxLayoutTest();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// frame.setSize(500,600);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public BoxLayoutTest() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			BoxLayout bl = new BoxLayout(jContentPane, BoxLayout.Y_AXIS);

			jContentPane.setLayout(bl);
			jContentPane.add(getJButton(), null);
			jContentPane.add(Box.createVerticalGlue());
			// jContentPane.add(Box.createRigidArea(new Dimension(2,50))) ;
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

} // @jve:decl-index=0:visual-constraint="33,23"
