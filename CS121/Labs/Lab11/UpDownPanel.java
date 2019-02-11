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
	int hello = 50;
	private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	 
	private JButton left, right;
	private JLabel label;
	private JPanel buttonPanel;

	/**
	 * Constructor: Sets up the GUI.
	 */
	public UpDownPanel()
	{
		label = new JLabel("" + hello + "");
		left = new JButton("Up");
		right = new JButton("Down");

		// add the same listener object to both buttons
		ButtonListener listener = new ButtonListener();
		left.addActionListener(listener);
		right.addActionListener(listener);

		// create a sub-panel to hold the left/right buttons.
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(200, 40));
		buttonPanel.setBackground(Color.orange);
		
		// add the buttons to the sub-panel
		buttonPanel.add(left);
		buttonPanel.add(right);
		
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

			if (event.getSource() == left) {
				hello = hello + 50;
				label.setText("" + hello + "");
			} else {
				label.setText("" + hello + "");
				hello = hello - 50;
			}
		}
	}
}