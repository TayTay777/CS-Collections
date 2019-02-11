import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Displays a grid of JButtons and a JTextArea. Together,
 * they act as a very small keyboard and text display.
 * This class manages layout of controls and also handles events.
 * 
 * @author mvail
 * @author taylorpaulroberts
 */
@SuppressWarnings("serial")
public class TextButtonsPanel extends JPanel implements ActionListener {
	private JButton[] buttons;	//Do not change
	private JTextArea textArea;	//Do not change
	//Assign values for these constants in the constructor
	private final int ENTER = 9;	//Index of Enter button in the buttons array
	private final int SPACE = 10;	//Index of Space button in buttons
	private final int CLEAR = 11;	//Index of Clear button in buttons

	/**
	 * Constructor
	 */
	public TextButtonsPanel() {




		String[] names = {"A", "B", "C",
				"1", "2", "3",
				"X", "Y", "Z", "Enter", "Space", "Clear"};


		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);



		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(200, 120));




		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4, 3));
		//gridPanel.setPreferredSize(new Dimension());


		buttons = new JButton[12];
		for (int i = 0; i < buttons.length; i++) 
		{
			buttons[i] = new JButton();
			buttons[i].setText(names[i]);
			buttons[i].addActionListener(this);
			gridPanel.add(buttons[i]);
		}
		//TODO: Create and populate the buttons array
		//TODO: Register this as the listener for all buttons
		//TODO: Create the text area - set its editable property to false

		//TODO: Create a sub-panel with a 4 row, 3 column GridLayout
		//TODO: Populate the grid with buttons
		//TODO: Add the grid panel to this panel

		//TODO: Create a JScrollPane containing textArea
		//TODO: Set the preferred size of the scroll pane to at least 80x120
		//TODO: Add the scroll pane to this panel
		this.add(gridPanel);
		//this.add(TxtInput);
		this.add(scrollPane);
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO update the contents of textArea according to which
		//  button generated the ActionEvent.

		JButton source = (JButton) e.getSource();

		int i=0;
		for(; i<buttons.length; ++i)
		{
			if (source == buttons[i]) break;
		}

		switch(i) {
		case ENTER:
			textArea.append("\n");
			break;
		case CLEAR:
			textArea.setText("");
			break;
		case SPACE:
			textArea.append(" ");
			break;
		default:
			textArea.append("" + buttons[i].getText() + "");
			break;
		}

	}
}
