import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;

public class GridMonitor implements GridMonitorInterface 
{
	
	
	
	private String filename;
	private File cFile;
	private Scanner fileScan;
	private Scanner lineScan;
	private int rows;
	private int collumns;
	private double[][] theGrid;
	private String firstLine;
	public String numbers;
	
	
	
	public GridMonitor(String filename) throws FileNotFoundException
	{
		this.filename = filename;
		cFile = new File(filename);
		theGrid = new double[rows][collumns];
		
		
		
		try {
			Scanner fileScan = new Scanner(cFile);

			while (fileScan.hasNextLine()) {

				String line = fileScan.nextLine();

				lineScan = new Scanner(line);

				while (lineScan.hasNext()) {

					String token = lineScan.next();
					
					numbers += token;
					
					
				}
				lineScan.close();

			}

			fileScan.close();
		} catch (FileNotFoundException e) {
		
		
		
//		for (int row = 0; row < theGrid.length; row++) {
//			for (int col = 0; col < theGrid[row].length; col++) 
//			{
//				buttons[row][col] = new JButton();
//				buttons[row][col].addActionListener(this);
//				buttons[row][col].setBackground(Color.GRAY);
//				buttons[row][col].setPreferredSize(new Dimension(60, 60));
//				gridPanel.add(buttons[row][col]);
//			}
//			
			
			
			
			
			
			
			
		}
		
	}

	@Override
	public double[][] getBaseGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[][] getSurroundingSumGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[][] getSurroundingAvgGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[][] getDeltaGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[][] getDangerGrid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String test()
	{
		return firstLine;
	}

}
