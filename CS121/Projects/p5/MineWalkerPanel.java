import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MineWalkerPanel extends JPanel implements ActionListener {

	private JButton[][] buttons;
	private int score;
	private int lives = 5;
	private int gridSize = 10;
	private RandomWalk myPath = new RandomWalk(gridSize);
	private JButton showMines;
	private JButton showPath;
	private JButton giveUp;
	private JButton updateGrid;
	private JPanel gridPanel;
	private ArrayList<Point> newPath;
	private ArrayList<Point> mines;
	private Point p = null;
	private Point currentPosition = null;
	private Point bombPoint = null;
	private int numOfMines;// = gridSize * gridSize / 4;
	private JTextField gridInput;
	private JLabel livesScore;
	public MineWalkerPanel()

	{

		
		//Establishes a border layout 
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(900, 700));
		this.setBackground(Color.BLACK);

		//Creates the new grid panel
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(10, 10));
		gridPanel.setPreferredSize(new Dimension(250, 250));
		p = null;
		buttons = new JButton[gridSize][gridSize];
		myPath.createWalk();
		newPath = myPath.getPath();
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				p = new Point(row, col);
				buttons[row][col] = new JButton();
				buttons[row][col].setFont(new Font("Arial", 0, 32));
				buttons[row][col].setText("");
				buttons[row][col].addActionListener(this);
				buttons[row][col].setBackground(Color.GRAY);
				buttons[row][col].setPreferredSize(new Dimension(60, 60));
				gridPanel.add(buttons[row][col]);

				// if (newPath.contains((p)))
				// {
				// buttons[p.x][p.y].setBackground(Color.BLUE);
				// }
			}
		}
		currentPosition = new Point(gridSize - 1, gridSize - 1);
		makeMines();
		buttons[0][0].setBackground(Color.blue);
		buttons[gridSize - 1][gridSize - 1].setBackground(Color.CYAN);

		
		
		
		//score layout 
		JPanel bottomPanel = new JPanel();
		livesScore = new JLabel("Lives: " + lives + "     Score: " + score);
		bottomPanel.add(livesScore);

		
		
		
		// Right Side of border layout (east)
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		giveUp = new JButton("Give up?");
		giveUp.setAlignmentX(Component.CENTER_ALIGNMENT);
		gridInput = new JTextField(3);
		gridInput.setText(Integer.toString(gridSize));
		gridInput.setMinimumSize(new Dimension(40, 20));
		gridInput.setPreferredSize(new Dimension(40, 20));
		gridInput.setMaximumSize(new Dimension(40, 20));
		JLabel gridSize = new JLabel("Grid Size: ");
		gridSize.setAlignmentX(Component.CENTER_ALIGNMENT);
		gridInput.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateGrid = new JButton("Update Grid");
		updateGrid.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateGrid.setMinimumSize(new Dimension(140, 50));
		updateGrid.setPreferredSize(new Dimension(140, 50));
		updateGrid.setMaximumSize(new Dimension(140, 50));
		showMines = new JButton("Show Mines");
		showMines.setAlignmentX(Component.CENTER_ALIGNMENT);
		showPath = new JButton("Show Path");
		showPath.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		giveUp.setMinimumSize(new Dimension(140, 50));
		giveUp.setPreferredSize(new Dimension(140, 50));
		giveUp.setMaximumSize(new Dimension(140, 50));
		rightPanel.add(giveUp);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		rightPanel.add(gridSize);
		rightPanel.add(gridInput);
		rightPanel.add(updateGrid);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		showMines.setMinimumSize(new Dimension(140, 50));
		showMines.setPreferredSize(new Dimension(140, 50));
		showMines.setMaximumSize(new Dimension(140, 50));
		rightPanel.add(showMines);
		showPath.setMinimumSize(new Dimension(140, 50));
		showPath.setPreferredSize(new Dimension(140, 50));
		showPath.setMaximumSize(new Dimension(140, 50));
		rightPanel.add(showPath);

		// Left Side of border layout (west)
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JLabel key = new JLabel("Key");
		JLabel greenNM = new JLabel("0 Nearby Mines      ");
		greenNM.setOpaque(true);
		greenNM.setBackground(Color.green);
		greenNM.setMinimumSize(new Dimension(140, 50));
		greenNM.setPreferredSize(new Dimension(140, 50));
		greenNM.setMaximumSize(new Dimension(140, 50));
		JLabel yellowNM = new JLabel("1 Nearby Mines      ");
		yellowNM.setOpaque(true);
		yellowNM.setBackground(Color.yellow);
		yellowNM.setMinimumSize(new Dimension(140, 50));
		yellowNM.setPreferredSize(new Dimension(140, 50));
		yellowNM.setMaximumSize(new Dimension(140, 50));
		JLabel orangeNM = new JLabel("2 Nearby Mines      ");
		orangeNM.setOpaque(true);
		orangeNM.setBackground(Color.orange);
		orangeNM.setMinimumSize(new Dimension(140, 50));
		orangeNM.setPreferredSize(new Dimension(140, 50));
		orangeNM.setMaximumSize(new Dimension(140, 50));
		JLabel redNM = new JLabel("3 Nearby Mines      ");
		redNM.setOpaque(true);
		redNM.setBackground(Color.red);
		redNM.setMinimumSize(new Dimension(140, 50));
		redNM.setPreferredSize(new Dimension(140, 50));
		redNM.setMaximumSize(new Dimension(140, 50));
		JLabel exMines = new JLabel("Exploded Mine        ");
		exMines.setOpaque(true);
		exMines.setBackground(Color.black);
		exMines.setForeground(Color.red);
		exMines.setMinimumSize(new Dimension(140, 50));
		exMines.setPreferredSize(new Dimension(140, 50));
		exMines.setMaximumSize(new Dimension(140, 50));
		JLabel currentPos = new JLabel("'X' Current Postion");
		currentPos.setOpaque(true);
		currentPos.setBackground(Color.GRAY);
		currentPos.setForeground(Color.white);
		currentPos.setMinimumSize(new Dimension(140, 50));
		currentPos.setPreferredSize(new Dimension(140, 50));
		currentPos.setMaximumSize(new Dimension(140, 50));
		JLabel destination = new JLabel("Destination             ");
		destination.setOpaque(true);
		destination.setBackground(Color.blue);
		destination.setForeground(Color.white);
		destination.setMinimumSize(new Dimension(140, 50));
		destination.setPreferredSize(new Dimension(140, 50));
		destination.setMaximumSize(new Dimension(140, 50));
		leftPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		leftPanel.add(key);
		leftPanel.add(greenNM);
		leftPanel.add(yellowNM);
		leftPanel.add(orangeNM);
		leftPanel.add(redNM);
		leftPanel.add(exMines);
		leftPanel.add(currentPos);
		leftPanel.add(destination);

		// Top Labeling
		JPanel topPanel = new JPanel();
		JLabel title = new JLabel("MINE WALKER");
		topPanel.add(title);

		//added action listeners
		giveUp.addActionListener(this);
		showMines.addActionListener(this);
		showPath.addActionListener(this);
		// gridInput.addActionListener(this);
		updateGrid.addActionListener(this);

		// Added to main JPanel
		this.add(gridPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(topPanel, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		//makes source to any Jbutton
		JButton source = (JButton) e.getSource();

		
		//updates sthe gridsize by re-establishing a new gridPanel
		if (source == updateGrid) {
			updateGridPanel();
		}

		// resets the path based on action event
		else if (source == giveUp) {
			if (source.getText().equals("Give up?")) {
				showPath();
				showMines();
				giveUp.setText("New Game?");

			} else if (source.getText().equals("New Game?")) {
				makeNewGame();
				makeMines();

			}
		}

		// Show path Action event
		else if (source == showPath) {
			showPath();
		}

		// shows mines action event
		else if (source == showMines) {
			showMines();
		}

		/**
		 * turns the player's current position to the color corresponding to the amount of mines 
		 * that are around the player and keeps an "x" on the current position.
		 *
		 */
		else {
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) 
				{
					buttons[row][col].setText("");
					if (source.equals(buttons[row][col])) 
					{
						Point p = new Point(row, col);
						if (valid(p))
						{

							if (isMine(p)) 
							{
								// do mine stuff
								buttons[row][col].setBackground(Color.BLACK);
								
								lives();
							} 
							else 
							{
								currentPosition = new Point(row, col);

								if (numOfMines(currentPosition) == 0)
								{
									buttons[row][col].setBackground(Color.green);
									//source.setText("X");
								}
								if (numOfMines(currentPosition) == 1)
								{
									buttons[row][col].setBackground(Color.yellow);
									//source.setText("X");
								}
								if (numOfMines(currentPosition) == 2)
								{
									buttons[row][col].setBackground(Color.orange);
									//source.setText("X");
								}
								if (numOfMines(currentPosition) == 3)
								{
									buttons[row][col].setBackground(Color.red);
									//source.setText("X");
								}
								if (numOfMines(currentPosition) == 4)
								{
									buttons[row][col].setBackground(Color.blue);
									//source.setText(setFointsize"X");
								}

								if (source.equals(buttons[row][col]))
								{
									source.setText("x");
								}
								
								if (source.equals(buttons[0][0]))
								{
									JOptionPane.showMessageDialog(null, "You Win!");
								}

								//buttons[row][col].setBackground(Color.blue);

							}
						}
						else
						{
							//not valid
						}
					}
				}
			}

		}

	}

	/**
	 * shows where the mines are for the player
	 */
	private void showMines() {
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				p = new Point(row, col);
				if (mines.contains((p))) {
					buttons[row][col].setBackground(Color.black);
				}
			}
		}
	}

	/**
	 * makes about 1/4 of the tiles mines in randomly generated areas. Avoids the path 
	 * for the player
	 */
	private void makeMines() {
		numOfMines = gridSize * gridSize / 4;
		mines = new ArrayList<Point>();
		bombPoint = null;
		Random rand = new Random();
		for (int i = 0; i < (numOfMines - 1); i++) {
			int x = rand.nextInt(gridSize);
			int y = rand.nextInt(gridSize);
			bombPoint = new Point(x, y);
			if (!newPath.contains(bombPoint) && !mines.contains(bombPoint)) {
				mines.add(bombPoint);
			}

		}

	}

	/**
	 * resets the buttons on the gridPanel to default
	 */
	private void makeNewGame() {
		giveUpGame();
		myPath = new RandomWalk(gridSize);
		myPath.createWalk();
		newPath = myPath.getPath();
		for (int row = 0; row < buttons.length; row++) 
		{
			for (int col = 0; col < buttons[row].length; col++) 
			{
				buttons[row][col].setText("");
				p = new Point(row, col);
				buttons[row][col].setBackground(Color.GRAY);
				//buttons[p.x][p.y].setBackground(Color.BLUE);

				buttons[0][0].setBackground(Color.blue);
				buttons[gridSize - 1][gridSize - 1].setBackground(Color.CYAN);
			}
		}
		currentPosition = new Point(gridSize - 1, gridSize - 1);
	}

	/**
	 * shows the computer generated path that the program avoids placing mines on. 
	 * this path is to ensure that the player can reach the goad without hitting any mines.
	 */
	private void showPath() {
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				p = new Point(row, col);
				if (newPath.contains((p))) {
					buttons[p.x][p.y].setBackground(Color.BLUE);
				}
				buttons[0][0].setBackground(Color.blue);
				buttons[gridSize - 1][gridSize - 1].setBackground(Color.blue);
			}
		}
	}

	/**
	 * resets the tiles on the game
	 */
	private void giveUpGame() {
		p = null;
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				p = new Point(row, col);
				if (newPath.contains((p))) {
					buttons[p.x][p.y].setBackground(Color.orange);
				}
				if (mines.contains((p))) {
					buttons[p.x][p.y].setBackground(Color.orange);
				}
			}
		}
		newPath.clear();
		giveUp.setText("New Game?");
	}

	/**
	 * updates the grid panel size to new size entered into the JTextField area.
	 */
	private void updateGridPanel() {
		int oldGridDim = gridSize; // store in case invalid value in gridDimText
		try {
			gridSize = Integer.parseInt(gridInput.getText().trim());
			if (gridSize < 1) { // invalid dimension
				// reset gridDim and text field to previous
				// values
				gridSize = oldGridDim;
				gridInput.setText(Integer.toString(gridSize));
			} else { // valid input, so configure a new gridPanel
				if (gridPanel != null) { // if we have a previous gridPanel
					this.remove(gridPanel);
				}
				gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(gridSize, gridSize));
				// populate gridPanel with labels
				buttons = new JButton[gridSize][gridSize];
				for (int row = 0; row < buttons.length; row++) {
					for (int col = 0; col < buttons[row].length; col++) 
					{
						p = new Point(row, col);
						buttons[row][col] = new JButton();
						buttons[row][col].addActionListener(this);
						buttons[row][col].setBackground(Color.GRAY);
						buttons[row][col].setPreferredSize(new Dimension(60, 60));
						gridPanel.add(buttons[row][col]);
					}
				}
				// add new gridPanel to primary panel
				this.add(gridPanel, BorderLayout.CENTER);
				this.revalidate(); // causes panel to refresh itself with new
				// contents
			}
		} catch (NumberFormatException nfe) { // invalid input in text field
			// reset gridDim and text field
			// to previous values
			gridSize = oldGridDim;
			gridInput.setText(Integer.toString(gridSize));
		}

		currentPosition = new Point(gridSize - 1, gridSize - 1);
		makeNewGame();
		makeMines();

	}

	
	/**
	 * 
	 * @param position
	 * @return made to ensure the player can only choose valid path direction
	 */
	private boolean valid(Point position) {
		if (position.x == currentPosition.x + 1 && position.y == currentPosition.y) {
			return true;
		}

		if (position.x == currentPosition.x - 1 && position.y == currentPosition.y) {
			return true;
		}

		if (position.x == currentPosition.x && position.y == currentPosition.y + 1) {
			return true;
		}

		if (position.x == currentPosition.x && position.y == currentPosition.y - 1) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param p
	 * @return returns true if the player lands on a mine, used to check for mines
	 */
	private boolean isMine(Point p) {
		return mines.contains(p);
	}

	/**
	 * 
	 * @param position
	 * @return the number of mines that is around the player's position
	 */
	private int numOfMines(Point position)
	{
		int i = 0;
		if (mines.contains(new Point (position.x + 1, position.y)))
		{
			i++;
		}
		if (mines.contains(new Point (position.x - 1, position.y)))
		{
			i++;
		}
		if (mines.contains(new Point (position.x, position.y +1)))
		{
			i++;
		}
		if (mines.contains(new Point (position.x, position.y - 1)))
		{
			i++;
		}


		return i;
	}

	/**
	 * method to sutract lives if the player lands on a mine
	 */
	public void lives()
	{
		lives = lives -1;
	}


}
