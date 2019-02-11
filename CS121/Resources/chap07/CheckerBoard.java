import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Demonstrates the use of 2-D arrays to represent a grid.
 * 
 * @author Lewis/Loftus/amit
 * 
 */
public class CheckerBoard extends JPanel
{
	/**
	 * Sets up the checker board panel.
	 */
	public CheckerBoard()
	{
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(500, 500));
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		int x = 0, y = 0;
		int width = getWidth();
		int height = getHeight();
		
		Color[][] colors = getBoardColors();
		
		int boxWidth = width/colors.length; // assumes it is a square
		int boxHeight = height/colors.length;

		page.setColor(Color.white);
		
		for (int row = 0; row < colors.length; row++)
		{
			for (int col = 0; col < colors[row].length; col++)
			{
				page.setColor(colors[row][col]);
				page.fillRect(x, y, boxWidth, boxHeight);
				x += boxWidth;
			}
			x = 0;
			y += boxHeight;
		}
	}
	
	public Color[][] getBoardColors()
	{
		Color[][] board = new Color[8][8];
		for (int row = 0; row < board.length; row++)
		{
		   for (int col = 0; col < board[row].length; col++)
		   {
		       if(row % 2 == col%2)
		    	   board[row][col] = Color.red;
		       else
		    	   board[row][col] = Color.white;
		    }
		}
		return board;
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerBoard panel = new CheckerBoard();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
