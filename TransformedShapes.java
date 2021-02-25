package lab1Zad2;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class TransformedShapes extends JPanel {


	private Graphics2D g2;

	
	private void resetTransform() {
		g2.setTransform(new AffineTransform());
	}

	private void square() {
		g2.fillRect(-50,-50,100,100);
	}

	private void triangle() {
		g2.fillPolygon(new int[] {-50,50,0}, new int[] {50,50,-50}, 3);
	}

	


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		

		g2.translate(450,150);
		g2.scale(2,2);
		g2.setColor(Color.GREEN);
		square();
		resetTransform();
		
		g2.translate(450,200);
		g2.setColor(Color.WHITE);
		g2.scale(2,1);
		triangle();
	

		

		
	} 


	
	
	public TransformedShapes() {
		setPreferredSize(new Dimension(600,600) );
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public static void main(String[] args)  {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new TransformedShapes());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}