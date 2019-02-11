import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the panel in the LayoutDemo program that demonstrates the grid
 * layout manager.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class GridPanel extends JPanel
{
	private final Color LIGHT_GREEN = new Color(206, 255, 199);
	
	/**
	 * Sets up this panel with some buttons to show how grid layout affects
	 * their position, shape, and size.
	 */
	public GridPanel()
	{
		setLayout(new GridLayout(2, 3));		
		setBackground(LIGHT_GREEN);

		JButton[] buttons = new JButton[5];
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("BUTTON " + (i + 1));
			buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
			add(buttons[i]);
		}
	}
}
