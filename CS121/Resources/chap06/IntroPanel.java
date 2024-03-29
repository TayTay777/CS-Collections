import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents the introduction panel for the LayoutDemo program.
 * 
 * @author Java Foundations
 */
public class IntroPanel extends JPanel {

	/**
	 * Sets up this panel with two labels.
	 */
	public IntroPanel()
	{
		
		setPreferredSize(new Dimension(400, 400));
		Color lightGreen = new Color(206, 255, 199);
		setBackground(lightGreen);

		JLabel l1 = new JLabel("Layout Manager Demonstration");
		JLabel l2 = new JLabel("Choose a tab to see an example of "
				+ "a layout manager.");
		add(l1);
		add(l2);
	}
}
