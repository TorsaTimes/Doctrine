import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MeinRahmen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame f = new JFrame("Beispiel für Label");
		f.add(new JLabel("Hallo Welt"), BorderLayout.CENTER);
		JButton knopf = new JButton("Knopf");
		f.add(knopf, BorderLayout.NORTH);
		knopf.addActionListener(
				new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Toolkit.getDefaultToolkit();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(arg0.getSource());
			}
		});
		// f.setLocationByPlatform(true);
		f.setLocation(0, 0);
		f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		f.setResizable(false);
		f.setUndecorated(true);
		f.setVisible(true);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runnable rahmenGroesse = new Runnable() {
			public void run() {
				f.setSize(new Dimension(100, 500));
				f.setUndecorated(false);
				f.setResizable(true);
			}
		};
		EventQueue.invokeLater(rahmenGroesse);

		// Frame fawt = new Frame( "Das Fenster zur Welt" );
		// fawt.setLocationByPlatform(true);
		// // fawt.setResizable(false);
		// fawt.setSize( 300, 200 );
		// fawt.setLocation( 0, 0 );
		// fawt.setSize(
		// Toolkit.getDefaultToolkit().getScreenSize() );
		//
		// fawt.setVisible( true );

	}
}
