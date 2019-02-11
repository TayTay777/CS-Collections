import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animated program with a ball bouncing off the program boundaries
 * @author mvail
 * @author yourname
 */
public class BouncyBall extends JPanel
{
	int rDelta = 1;
	private final int INIT_WIDTH = 600;
	private final int INIT_HEIGHT = 400;
	private final int DELAY = 50; // milliseconds between Timer events
	private Random rand; //random number generator
	private int x, y; //anchor point coordinates
	private int xDelta, yDelta; //change in x and y from one step to the next
	private final int DELTA_RANGE = 20; //range for xDelta and yDelta
	private int RADIUS = 10; //circle radius


	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		g.setColor(getBackground());
		g.fillRect(0, 0, width, height);
		
		RADIUS = RADIUS + rDelta ;
		if (RADIUS >= 100)
		{
			rDelta = rDelta * -1;
		}
		if (RADIUS <= 10)
		{
			rDelta = rDelta * -1;
		}


		x = x + xDelta;
		if (x + RADIUS >= width) 
			{xDelta = xDelta * -1;
			x = width - RADIUS;
			}
		if (x - RADIUS <= 0)
			{xDelta = xDelta * -1;
			x = 0 + RADIUS;}

		y += yDelta;
		if (y + RADIUS >= height)
			{yDelta = yDelta * -1;
			y = height - RADIUS;}
		if (y - RADIUS <= 0)
			{yDelta = yDelta * -1;
			y = 0 + RADIUS;}
		
		int RandomRGB = rand.nextInt(256);
		int RandomRGB2 = rand.nextInt(256);
		int RandomRGB3 = rand.nextInt(256);
		g.setColor(new Color(RandomRGB, RandomRGB2, RandomRGB3));
		g.fillOval(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);

		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public BouncyBall()
	{
		setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		this.setDoubleBuffered(true);
		setBackground(Color.black);

		rand = new Random(); 

		//initial ball location within panel bounds
		x = rand.nextInt(INIT_WIDTH - RADIUS) + (RADIUS);
		y = rand.nextInt(INIT_HEIGHT - RADIUS) + (RADIUS);
		//TODO: replace centered starting point with a random
		// position anywhere in-bounds - the ball should never
		// extend out of bounds, so you'll need to take RADIUS
		// into account

		//deltas for x and y
		xDelta = 5;
		yDelta = 5;
		//TODO: replace with random deltas from -DELTA_RANGE/2
		// to +DELTA_RANGE/2

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically
	 * DO NOT MODIFY
	 */
	private void startAnimation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}

	/**
	 * Starting point for the BouncyBall program
	 * DO NOT MODIFY
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Bouncy Ball");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BouncyBall());
		frame.pack();
		frame.setVisible(true);
	}

}
