package lab1Zad1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300); // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex();
			if(whichTransform ==0)
			{
				
			}
			if(whichTransform ==1)
			{
				
			}
			if(whichTransform ==2)
			{
				g2.scale(2,2);
				g2.rotate(0.7853981633974);
			}
			if(whichTransform ==3)
			{
				g2.scale(1.5,1.5);
				g2.rotate(3.14159265359);
			}
			if(whichTransform ==4)
			{
				g2.scale(1.5,1.5);
				g2.shear(0.4,0.0);
			}
			if(whichTransform ==5)
			{
				g2.scale(2,1);
				g2.translate(0,-157.5);
			}
			if(whichTransform ==6)
			{
				g2.rotate(1.570796326795);
				g2.shear(0, 0.4);
				g2.scale(1.5,1.5);
			}
			if(whichTransform ==7)
			{
				g2.scale(1.5,1.5);
				g2.rotate(3.14159265359);
			}
			if(whichTransform ==8)
			{
				g2.translate(-80,110);
				g2.scale(1.75,1);
				g2.rotate(0.5235987755983);
				
			}
			if(whichTransform ==9)
			{
				
				g2.scale(1.5,1.5);
				g2.rotate(3.14159265359);
				g2.shear(0.2,0.4);
				g2.translate(-60,0);
			}
			// TODO Apply transforms here, depending on the value of whichTransform!
			
			g2.setColor(Color.GREEN);
			Polygon p = new Polygon();
	        for (int i = 0; i < 10; i++)
	            p.addPoint((int) (0 + 150 * Math.cos(i * 2 * Math.PI / 10)),
	              (int) (0 + 150 * Math.sin(i * 2 * Math.PI / 10)));        
	        g2.fillPolygon(p);
	        
		}
	}

	private Display display;
	private BufferedImage pic;
	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
	
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}