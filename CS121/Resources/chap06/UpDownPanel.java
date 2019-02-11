import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates the use of one listener for multiple buttons.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class UpDownPanel extends JPanel
{
	private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	 
	private JButton up, down;
	private JLabel label;
	private JPanel buttonPanel;
	private int count;

	/**
	 * Constructor: Sets up the GUI.
	 */
	public UpDownPanel()
	{
		count = 0;
		
		label = new JLabel("Count: " + count);
		up = new JButton("Up");
		down = new JButton("Down");

		// add the same listener object to both buttons
		ButtonListener listener = new ButtonListener();
		up.addActionListener(listener);
		down.addActionListener(listener);

		// create a sub-panel to hold the left/right buttons.
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(200, 40));
		buttonPanel.setBackground(Color.orange);
		
		// add the buttons to the sub-panel
		buttonPanel.add(up);
		buttonPanel.add(down);
		
		// add the label and sub-panel to this main panel
		add(label);
		add(buttonPanel);
		
		setBackground(LIGHT_GREEN);
		setPreferredSize(new Dimension(200, 80));
	}

	/**
	 * Represents a listener for both buttons.
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * Determines which button was pressed and sets the label text accordingly.
		 */
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == up) {
				count++;
			} else {
				count--;
			}
			label.setText("Count: " + count);
		}
	}
}
