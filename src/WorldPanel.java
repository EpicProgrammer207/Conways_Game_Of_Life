import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//calculate the cellSize
	cellSize = 2;
		
		//initialize the cells array
		cells = new Cell[h][w];
		
		//initialize each cell in the array
		for(int i = 0; i<cells.length; i++) {
			for(int j = 0; j<cells[i].length; j++) {
				cells[i][j] = new Cell(cellSize*j, cellSize*i, cellSize);
			}
		}
	}
	
	public void randomizeCells() {
		int random = new Random().nextInt(2);
		for(int i = 0; i<cells.length; i++) {
			for(int j = 0; j<cells[i].length; j++) {
				if(random == 0) {
					cells[i][j].isAlive = false;
				}
				else if(random == 1) {
					cells[i][j].isAlive = true;
				}
				random = new Random().nextInt(2);
			}
		}
		// make each cell alive or dead randomly
		repaint();
	}
	
	public void clearCells() {
		// set isAlive to false for all cells
		for(int i = 0; i<cells.length; i++) {
			for(int j = 0; j<cells[i].length; j++) {
					cells[i][j].isAlive = false;
			}
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i<cells.length; i++) {
			for(int j = 0; j<cells[i].length; j++) {
					cells[i][j].draw(g);
			}
		}

		//iterate through the cells and draw them
	
	}
	
	//advances world one step
	public void step() {
		//initialize the numLivingNbors variable to be the same size as the cells
		int[][] numLivingNbors;
		numLivingNbors = new int[cellsPerRow][cells[0].length];
		//iterate through the cells and populate the numLivingNbors array with their neighbors
		
		
		repaint();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		
		//add 1 to livingNeighbors for each
		//neighboring cell that is alive
		
		return livingNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//get the location of the mouse
		
		//toggle the cell at that location to either alive or dead
		//based on its current state
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
