

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Centers a string of text in the window
 * @author Java, Java, Java, 2E, converted to GUI by mvail
 */
public class CenterText extends JPanel {
    /**
     * displays a text string centered in the window.
     */
    public void paintComponent(Graphics g) {
    	// clears the background
    	super.paintComponent(g);
    	
        String str = "Hello World!";

        g.setFont(new Font("Serif", Font.BOLD, 36));  
        // Get Font's metrics to allows us to figure out it's size
        FontMetrics metrics = g.getFontMetrics(); 
        
        // Get the frame's size
        int width = getWidth();
        int height = getHeight();
        
        setBackground(Color.orange);
        g.setColor(Color.black);

        // calculate center point coordinates to place the string
        int x = (width - metrics.stringWidth(str))/2; 
        int y = (height + metrics.getHeight())/2;

        g.drawString(str, x, y); 
    }
   
	
	/**
	 * Constructor (panel initialization)
	 */
	public CenterText()
	{
		setPreferredSize(new Dimension(500, 500));
	}
	
	
	/**
	 * Starting point for CenterText application.
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("CenterText");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new CenterText());
		frame.pack();
		frame.setVisible(true);
	}
} 
