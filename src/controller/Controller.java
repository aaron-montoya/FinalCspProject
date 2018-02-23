package controller;

import view.GUIFrame;

public class Controller
{
	private GUIFrame appFrame;
	
	public Controller()
	{
		appFrame = new GUIFrame(this);
	}
	
	public void start()
	{
		boolean[][] gameGrid = new boolean[20][20];
		
		for(int row = 0; row < gameGrid.length; row++)
		{
			for(int col = 0; col < gameGrid[0].length; col++)
			{
				gameGrid[row][col] = false;
			}
		}
	}
}
