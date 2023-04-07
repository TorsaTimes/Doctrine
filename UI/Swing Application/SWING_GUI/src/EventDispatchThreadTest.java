import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class EventDispatchThreadTest {
	
	
	
	public static void main(String[] args) {
		
		
		
		JFrame rahmen = new JFrame();
		rahmen.setSize(200, 200);
		rahmen.getContentPane().setLayout(null);
		
		JButton knopf1 = new JButton("OK");
		knopf1.setSize(100, 50);
		knopf1.setLocation(10, 10);
		knopf1.addActionListener(new ButtonExample());
		rahmen.getContentPane().add(knopf1);
		
		rahmen.setVisible(true);
try {
        	
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {}
//        rahmen.dispose();
//        while(true);

	}


}
class ButtonExample implements ActionListener {
	
	int a = 10000;
    public void actionPerformed(ActionEvent evt) {
      
        try {
        	
        	
        	
        	while(a != 0) {
        	System.out.println("Fuck you Button Pusher");
            
            System.out.println("Fuck you Button Pusher");
            a--;
        	}
        	Thread.sleep(10000);
        
        }
        catch(InterruptedException e) {}
    }
}
