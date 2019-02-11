import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



public class TicTacToePanel1 extends JPanel implements ActionListener {

	private String user = "X";
	private String Comp = "O";
	private JButton[][] buttons;
	private int computer; 
	private int player;
	
	public TicTacToePanel1() 
	{ 


		//JButton updateButton = new JButton("New Game");
		//updateButton.setPreferredSize(new Dimension(30, 20));
		
		this.setPreferredSize(new Dimension(250, 250));
		this.setLayout(new GridLayout(1, 1));

		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3, 3));
		//gridPanel.setPreferredSize(new Dimension(250, 250));
		
		//gridPanel.setPreferredSize(new Dimension(250, 250));
		gridPanel.setBackground(Color.red);


		//  


		buttons = new JButton[3][3];
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				buttons[row][col] = new JButton();
				buttons[row][col].setFont(new Font("Arial", 0, 32));
				buttons[row][col].setText("");
				buttons[row][col].addActionListener(this);
				buttons[row][col].setPreferredSize(new Dimension(50, 50));
				gridPanel.add(buttons[row][col]);
			}
		}

		this.add(gridPanel);
		//this.add(updateButton);




	}



	@Override
	public void actionPerformed(ActionEvent e) {


		JButton source = (JButton) e.getSource();

		source.setText(user);

		computerPlay();

	}




	public void computerPlay()
	{

		Boolean breek = false;
		for (int row = 0; row < buttons.length; row++) 
		{
			if (breek)
				break;
			for (int col = 0; col < buttons[row].length; col++) 
			{

				if (buttons[row][col].getText().equals("") )
				{
					buttons[row][col].setText("O");
					breek = true;
					break;
				}
			}	
		}
	}

//public void Winner()
//{
//	player = 0;
//	computer = 0;
//	if (buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[0][1].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][1].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X"))
//	{
//		player++;
//	}
//	if (buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X"))
//	{
//		player++;
//	}
//}





}
