import java.awt.Dimension;

import javax.swing.JFrame;

/*
 * 
 * @author taylorpaulroberts
 */
public class TicTacToe {

	/**
	 * Create the JFrame 
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("TicTacToePanel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); 

		TicTacToePanel mainPanel = new TicTacToePanel();
		
		f.getContentPane().add(mainPanel);
		f.pack();

		f.setVisible(true);
	}
}

