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



public class TicTacToePanel extends JPanel implements ActionListener {

	private String user = "X";
	private String Comp = "O";
	private JButton[][] buttons;
	public TicTacToePanel() 
	{ 

		
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new GridLayout(1, 1));

		  JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3, 3));
		gridPanel.setPreferredSize(new Dimension(500, 500));
		gridPanel.setBackground(Color.red);
		

		//  


//		buttons = new JButton[3][3];
//		for (int row = 0; row < buttons.length; row++) {
//			for (int col = 0; col < buttons[row].length; col++) {
//				buttons[row][col].setFont(new Font("Arial", 0, 32));
//				buttons[row][col] = new JButton();
//				buttons[row][col].setText("");
//				buttons[row][col].addActionListener(this);
//				buttons[row][col].setPreferredSize(new Dimension(50, 50));
//				gridPanel.add(buttons[row][col]);
//			}
//		}

		//this.add(gridPanel);




	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		JButton source = (JButton) e.getSource();
		
		source.setText("X");

	}











}
