package view;

import controller.Controller;
import javax.swing.JFrame;

public class GUIFrame extends JFrame
{
	private Controller appController;
	private GUIPanel appPanel;
	
	public GUIFrame(Controller controller)
	{
		super();
		this.appController = controller;
		this.appPanel = new GUIPanel(controller);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Game of Life");
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
