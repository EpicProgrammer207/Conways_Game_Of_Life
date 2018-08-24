import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  1. Check out the Wikipedia page on Conway's Game of Life to familiarize yourself
 *     with the concept.
 *     
 *	https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

/*
 *  2. Run the ConwaysGOL.jar to see a demo of the final product.
 */

/* 
 *  3. Create the program on your own or fill in the code under the comments to complete the project.
 *
 */

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static final int CELLS_PER_ROW = 350;
	
	private boolean isRunning = false;
	
	private JFrame window;
	private JPanel inputPanel;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JButton clearButton;
	private JLabel speedLabel;
	private JTextField speedField;
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {
		//build the window and start the simulation
		window = new JFrame("The Walmart Version Of The Board Game");
		//10/10 Jake Paul approves, WALMAAAAAAAAARRRRRRRRTTTTTTT!!!!!!!!!!!
		inputPanel = new JPanel();
		startStopButton = new JButton("Start");
		randomizeButton = new JButton("Cuz Everyone Loves Randomization!");
		clearButton = new JButton("Die");
		speedLabel= new JLabel("Gotta Go Fast %");
		startStopButton.addActionListener(this);
		randomizeButton.addActionListener(this);
		clearButton.addActionListener(this);
		//cuzynot
		speedField = new JTextField("60");
		speedField.setPreferredSize(new Dimension(40, 30));
		gamePanel = new WorldPanel(700, 700, 350);
		gamePanel.setVisible(true);
		inputPanel.add(startStopButton);
		inputPanel.add(randomizeButton);
		inputPanel.add(clearButton);
		inputPanel.add(speedLabel);
		inputPanel.add(speedField);
		inputPanel.add(gamePanel);
		//window.add(gamePanel);
		window.add(inputPanel);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if startStopButton is pressed, 
			if(e.getSource().equals(startStopButton)) {
				if(isRunning) {
					isRunning = false;
					gamePanel.stopAnimation();
				}
				else if(!isRunning) {
					isRunning = true;
					gamePanel.startAnimation();
				}
			}
			else if(e.getSource().equals(randomizeButton)) {
				gamePanel.randomizeCells();
			}
			else if(e.getSource().equals(clearButton)) {
				gamePanel.clearCells();
			}
		// toggle isRunning to the opposite of its current state
			// start or stop the animation based on the state of isRunning
		
		// if ranomizeButton(typo alert) is pressed
			// call randomizeCells
		
		// if clearButton is pressed
			//call clearCells
	}
	}

