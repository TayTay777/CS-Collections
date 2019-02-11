/* 
 * TrafficAnimation.java 
 * CS 121 Project 1: Traffic Animation
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animates a [put your description here]
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel {
	//Note: This area is where you declare constants and variables that
	//	need to keep their values between calls	to paintComponent().
	//	Any other variables should be declared locally, in the
	//	method where they are used.

	//constant to regulate the frequency of Timer events
	// Note: 100ms is 10 frames per second - you should not need
	// a faster refresh rate than this
	private final int DELAY = 100; //milliseconds
	//anchor coordinate for drawing / animating
	private int x = 0;
	//pixels added to x each time paintComponent() is called
	private int stepSize = 20
			;
	
	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//clears the previous image
		//super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		//Fill the canvas with the background color
		canvas.setColor(getBackground());
		canvas.fillRect(0, 0, width, height);
    	
		//Calculate the new position
		x = (x + stepSize) % (width + 600);
    	int x3 = (width - x);
    	int x4 = x -500;
    	
    	
		
		//The Mooooooooooon...
		canvas.setColor(new Color(255, 255, 204));
		canvas.fillOval(width * 12/16, height * 1/20, height * 2/20, height * 2/20);//moon background
		canvas.setColor(Color.white);
		canvas.fillOval(width * 12/16 + height * 1/43, height * 2/30, height * 1/60, height * 2/60);//eyes
		canvas.fillOval(width * 12/16 + height * 4/65, height * 2/30, height * 1/60, height * 2/60);
		canvas.setColor(Color.black);
		canvas.drawOval(width * 12/16 + height * 1/43, height * 2/30, height * 1/60, height * 2/60);//outline of eyes
		canvas.drawOval(width * 12/16 + height * 4/65, height * 2/30, height * 1/60, height * 2/60);
		canvas.setColor(Color.blue);
		canvas.fillOval(width * 12/16 + height * 1/38, height * 2/30 + height * 1/50, height * 1/120, height * 1/120);//eye pupils
		canvas.fillOval(width * 12/16 + height * 4/62, height * 2/30 + height * 1/50, height * 1/120, height * 1/120);
		//Moon END
		
		
		//Mountains
		canvas.setColor(new Color(102, 51, 0)); // Mid Mountain
		canvas.fillOval(width/5 + width/8, height/8, width/3 + width/6, height);
		canvas.setColor(new Color(153, 76, 0));
		canvas.fillOval(width - width - width/7, height/8, width/2, height);//Left Mountain
		canvas.fillOval(width/2 + width/5, height/8, width/2 + width/7, height);//Right Mountain
		//Mountains END
		
		
		//Roadway
		canvas.setColor(new Color(48,3,3));
		canvas.fillRect(0, height/2, width, height/2);
		//Roadway END
		
		//Grass 
		canvas.setColor(new Color(0,102,0));
		canvas.fillRect(0, height - height * 5/16, width, height);
		//Grass END
	
	
		//Vehicle Body
		int tov = height * 15/32;//t.o.v. is top of vehicle
		
		canvas.setColor(new Color(203,193,97));
		canvas.fillArc(x4 + height * 3/32, tov, height * 1/4, height * 1/6, 0, 90); 
		canvas.fillRect(x4 - height * 1/8, tov, height * 6/16, height * 1/12);
		canvas.fillRect(x4 - height * 1/8, tov + height/16, height * 15/32, height * 1/12);
		canvas.fillArc(x4 + height * 5/16, tov + height/16, height * 1/19, height * 1/19, 0, 90);
		canvas.fillRect(x4 - height * 1/8, tov + height/12, height * 33/67, height * 1/12);
		//Circular Windows
		
		int winHite = tov + height * 1/64;
		
		canvas.setColor(Color.lightGray);
		canvas.fillOval(x4, winHite, height * 3/40, height * 3/40);
		canvas.fillOval(x4 - height * 3/32, winHite, height * 3/40, height * 3/40);
		canvas.fillOval(x4 + height * 3/32, winHite, height * 3/40, height * 3/40);
		canvas.setColor(Color.BLACK);
		canvas.drawOval(x4, winHite, height * 3/40, height * 3/40);
		canvas.drawOval(x4 - height * 3/32, winHite, height * 3/40, height * 3/40);
		canvas.drawOval(x4 + height * 3/32, winHite, height * 3/40, height * 3/40);
		//Front Window
		canvas.setColor(Color.lightGray);
		canvas.fillArc(x4 + height * 3/32, winHite, height * 9/40, height * 6/40, 0, 90);
		canvas.setColor(Color.BLACK);
		canvas.drawArc(x4 + height * 3/32, winHite, height * 9/40, height * 6/40, 0, 90);
		//Wheels
		canvas.fillOval(x4 - height * 2/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.fillOval(x4 + height * 4/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.fillOval(x4 - height * 8/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.fillOval(x4 + height * 10/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.fillOval(x4 + height * 16/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.setColor(Color.red);
		canvas.drawOval(x4 - height * 2/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.drawOval(x4 + height * 4/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.drawOval(x4 - height * 8/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.drawOval(x4 + height * 10/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		canvas.drawOval(x4 + height * 16/64, winHite + height * 7/64, height * 3/40, height * 3/40);
		
		
		//UFO Background
		canvas.setColor(new Color(160,160,160));
		canvas.fillOval(x3, height * 12/64, height * 33/60, height * 4/40);
		canvas.setColor(Color.red);
		canvas.drawOval(x3, height * 12/64, height * 33/60, height * 4/40);
		
		canvas.setColor(Color.yellow);
		canvas.fillArc(x3 + height * 11/60, height * 91/600, height * 11/60, height * 5/40, 0, 180);
		canvas.fillArc(x3 + height * 11/60, height * 12/64, height * 11/60, height * 2/40, 180, 180);
		

		
		//TEXT START
		String str= "We are not alone...";
		int FontSize = height/20;
		canvas.setFont(new Font("Verdana", Font.BOLD, FontSize));  
	        // Get Font's metrics to allows us to figure out it's size
	    FontMetrics metrics = canvas.getFontMetrics(); 
		int x2 = (width - metrics.stringWidth(str))/2;
        int y2 = (height + metrics.getHeight())/2 + height/3;
		canvas.setColor (Color.green);
		canvas.drawString(str, x2, y2);
		//TEXT END
	}

	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public TrafficAnimation() 
	{
		setBackground(new Color(102,0,102));
		//Do not initialize larger than 800x600
		int initWidth = 800;
		int initHeight = 600;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);
		
		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/////////////////////////////////////////////
	// DO NOT MODIFY main() or startAnimation()
	/////////////////////////////////////////////
	
	/**
	 * Starting point for the TrafficAnimation program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

   /**
    * Create an animation thread that runs periodically
	* DO NOT MODIFY this method!
	*/
    private void startAnimation()
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                repaint();
            }
        };
        new Timer(DELAY, taskPerformer).start();
    }
}
