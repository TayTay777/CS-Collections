import javax.swing.JFrame;

/**
 * GUI contains a grid of buttons and a text area.
 * As buttons are pressed, corresponding text is
 * displayed in the text area.
 * 
 * @author mvail
 */
public class TextButtons {

	/**
	 * Create the JFrame 
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Text Buttons");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); //centers frame on screen

		//Create a TextButtonsPanel to display the buttons and textArea
		TextButtonsPanel mainPanel = new TextButtonsPanel();
		
		f.getContentPane().add(mainPanel);
		f.pack();

		f.setVisible(true);
	}
}

