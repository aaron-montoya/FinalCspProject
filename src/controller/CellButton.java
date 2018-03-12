package controller;

import javax.swing.*;
import java.awt.*;

import view.GUIPanel;

public class CellButton extends JButton
{
	boolean state = false;
	String text = "";
	
	private Controller appController;
	private GUIPanel appPanel;
	
	public CellButton(int pos, boolean state, String text)
	{
		this.setText(text);
		state = this.state;
	}
	
	public boolean getState()
	{
		return state;
	}
	
	public void setState(boolean state)
	{
		this.state = state;
	}
}
