import java.awt.*;

import javax.swing.*;



public class DrawingExample extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(30, 50, 200, 200);
    }
    
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.setSize(new Dimension(700,500));
    	frame.add(new DrawingExample(), BorderLayout.CENTER);
    	frame.setVisible(true);
    }
}
