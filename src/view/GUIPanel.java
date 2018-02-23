package view;

import javax.swing.*;
import controller.Controller;
import java.awt.event.*;
import java.awt.*;


public class GUIPanel extends JPanel
{
	private Controller appController;
	private JButton firstButton;
	private SpringLayout appLayout;
	
	public GUIPanel(Controller controller)
	{
		super();
		this.appController = controller;
		firstButton = new JButton("Start");
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		drawGrid();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(firstButton);
	}
	
	private void drawGrid()
	{
		for(int row = 0; row < 500; row+=25)
		{
			for(int col = 0; col < 500; col+=25)
			{
				//(row, col, row+25, col+25);
			}
		}
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(2));
		mainGraphics.setColor(Color.white);
		
		mainGraphics.drawRect(0, 0, 25, 25);
	}
	
}














