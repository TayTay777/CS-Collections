import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Draws gradients across the width of the panel
 * @author ?
 */
@SuppressWarnings("serial")
public class GradientLooperGrayscale extends JPanel {
	/* This method draws on the Graphics context.
	 * This is where your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//ready to paint
		super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		final int GRADIENT_DIVISIONS = 256;
		final int NUM_GRADIENT_BARS = 1;
		/* Notes
		 * int r = 0;
		 * int g = 0;
		 * int b = 0;
		 * for (int bar =0; bar < NUM_GRADIENT_BARS; ++bar)
		 * case 0
		 * 
		 * 
		 * canvas.setColor(r,g,b));
		 * canvas.setRect(x, y, width, height);
		 * ++r;
		 * ++g;
		 * ++b;
		 * 
		 * 
		 */
		for (int bar = 0; bar < NUM_GRADIENT_BARS; ++bar) {
			
			for (int i=0; i < GRADIENT_DIVISIONS; ++i) {
				//determin x
				//dertermin y
				//figure out which color to increment
				//set Color(r, g, b,)
				//drawRect(i, 0, width * 1/256, height);
			
				//use "break;" after every color transition to stop the color
				//Ex. 
				
				//case 0:
				
				//break;
				//case 1:
				
				//break;
				
			}
		}

		//TODO: Your code goes here

	}

	private void drawRect() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * DO NOT MODIFY
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 */
	public GradientLooperGrayscale() 
	{
		setBackground(Color.black);
		int initWidth = 768;
		int initHeight = 512;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);
	}

	/**
	 * DO NOT MODIFY
	 * Starting point for the program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("GradientLooperGrayscale");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GradientLooperGrayscale());
		frame.pack();
		frame.setVisible(true);
	}
}
