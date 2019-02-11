import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the panel in the LayoutDemo program that demonstrates the box
 * layout manager.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class BoxPanel extends JPanel
{
	/**
	 * Sets up this panel with some buttons to show how a vertical box layout
	 * (and invisible components) affects their position.
	 */
	public BoxPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Color lightGreen = new Color(206, 255, 199);
		setBackground(lightGreen);

		JButton b1 = new JButton("BUTTON 1");
		JButton b2 = new JButton("BUTTON 2");
		JButton b3 = new JButton("BUTTON 3");
		JButton b4 = new JButton("BUTTON 4");
		JButton b5 = new JButton("BUTTON 5");

		add(b1);
		add(Box.createRigidArea(new Dimension(20, 0)));
		add(b2);
		add(Box.createHorizontalGlue());
		add(b3);
		add(Box.createVerticalGlue());
		add(b4);
		add(Box.createVerticalGlue());
		add(b5);
	}
}
