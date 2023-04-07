import javax.swing.*;


public class FocusTest {

	
	public static void main(String[] args) {
		
		JFrame rahmen = new JFrame();
		rahmen.setSize(200, 200);
		rahmen.getContentPane().setLayout(null);
		
		JButton knopf1 = new JButton("OK");
		knopf1.setSize(100, 50);
		knopf1.setLocation(10, 10);
		rahmen.getContentPane().add(knopf1);
		
		JButton knopf2 = new JButton("Abbruch");
		knopf2.setSize(100, 50);
		knopf2.setLocation(10, 60);
		rahmen.getContentPane().add(knopf2);

		rahmen.getRootPane().setDefaultButton(knopf2);
		
		rahmen.setVisible(true);
		
	}
}
