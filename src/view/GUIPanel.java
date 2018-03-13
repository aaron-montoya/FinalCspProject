package view;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;
import controller.CellButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIPanel extends JPanel
{
	private Controller appController;
	private GridLayout appLayout;
	
	ArrayList<CellButton> buttons = new ArrayList();
	
	private CellButton buttonStart;
	private CellButton buttonEnd;
	
	public GUIPanel(Controller controller)
	{
		super();
		
		try
		{
		   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		
		this.appController = controller;
		appLayout = new GridLayout(10, 10);
		
		buttonStart = new CellButton(1, false, "");
		buttonStart.setBackground(Color.green);
		buttonStart.setOpaque(true);
		
		buttonEnd = new CellButton(1, false, "");
		buttonEnd.setBackground(Color.red);
		buttonEnd.setOpaque(true);
		
		setButtonColor();
		createButtons();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setButtonColor()
	{
		for(int index = 0; index < buttons.size(); index++)
			{
				if(buttons.get(index).getState() == false)
				{
					buttons.get(index).setBackground(Color.BLACK);
				}
				else if(buttons.get(index).getState() == true)
				{
					buttons.get(index).setBackground(Color.WHITE);
				}
			}
	}
	
	public ArrayList getButtons()
	{
		return buttons;
	}
	
	
	private void createButtons()
	{
		for(int index = 0; index < 99; index++)
		{
			CellButton sample = new CellButton(1, false, Integer.toString(index));
			sample.setBackground(Color.BLACK);
			sample.setOpaque(true);
			buttons.add(sample);
		}
		
		for(CellButton button : buttons)
		{
			this.add(button);
		}
	}
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(buttonStart);
		this.add(buttonEnd);
	}
	
	
	private void setupLayout()
	{
		
	}
	
	
	private void setupListeners()
	{
		for(CellButton button : buttons)
		{
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					boolean state = ((CellButton) click.getSource()).getState();
					((CellButton) click.getSource()).setState(!state);
					setButtonColor();
				}
			});
		}
		
		buttonStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int neighbors = 0;
				for(int count = 0; count < buttons.size(); count++)
				{
					if (buttons.get(count).getBackground() == Color.WHITE)
					{
						if (buttons.get(count - 12).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count - 11).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count - 10).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count - 1).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count + 1).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count + 10).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count + 11).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						if (buttons.get(count + 12).getBackground() == Color.BLACK)
						{
							neighbors++;
						}
						buttons.get(count).setText(Integer.toString(neighbors));
						neighbors = 0;
					}
				}
				buttonStart.setText(Integer.toString(neighbors));
				
				if (neighbors < 2 || neighbors > 3)
				{
					for(CellButton button : buttons)
					{
						((CellButton) click.getSource()).setState(false);
						setButtonColor();
					}
				}
				
				
			}
		});
		
		buttonEnd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
	
}














