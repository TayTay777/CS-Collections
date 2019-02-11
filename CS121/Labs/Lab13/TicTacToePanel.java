import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



public class TicTacToePanel extends JPanel implements ActionListener {

	private String user = "X";
	private String Comp = "O";
	private JButton[][] buttons;
	private int computer; 
	private int player;
	private JButton newGame;

	public TicTacToePanel() 
	{ 


		//JButton updateButton = new JButton("New Game");
		//updateButton.setPreferredSize(new Dimension(30, 20));
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(330, 250));



		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3, 3));
		gridPanel.setPreferredSize(new Dimension(250, 250));

		//gridPanel.setPreferredSize(new Dimension(250, 250));
		gridPanel.setBackground(Color.red);


		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		newGame = new JButton("New Game");
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		leftPanel.add(newGame);


		JPanel bottomPanel = new JPanel();
		JLabel winsLosses = new JLabel("Wins: " + player + "     Losses: " + computer);
		bottomPanel.add(winsLosses);




		buttons = new JButton[10][10];
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

		newGame.addActionListener(this);

		this.add(gridPanel, BorderLayout.CENTER);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(bottomPanel, BorderLayout.SOUTH);




	}



	@Override
	public void actionPerformed(ActionEvent e) {


		JButton source = (JButton) e.getSource();

		if (source == newGame)
		{
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					buttons[row][col].setText("");	
					source.setText("New Game");

				}
			}
			return;
		}

		if (source.getText().equals(""))
		{
			source.setText(user);
			computerPlay();
		}




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

	public void Winner()
	{
		player = 0;
		computer = 0;
		if (buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X"))
		{
			player++;
		}
		if (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X"))
		{
			player++;
		}
		if (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X"))
		{
			player++;
		}
		if (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X"))
		{
			player++;
		}
		if (buttons[0][1].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][1].getText().equals("X"))
		{
			player++;
		}
		if (buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals("X"))
		{
			player++;
		}
		if (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X"))
		{
			player++;
		}
		if (buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X"))
		{
			player++;
		}
	}





}
