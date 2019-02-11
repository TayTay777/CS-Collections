import javax.swing.JFrame;
import java.awt.Dimension;

public class MineWalker {

	/**
	 * Create the JFrame 
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("MineWalkerPanel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); 

		MineWalkerPanel mainPanel = new MineWalkerPanel();
		f.getContentPane().add(mainPanel);
		f.pack();

		
		f.setVisible(true);
	}
}
