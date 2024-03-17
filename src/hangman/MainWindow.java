package hangman;

import javax.swing.*;
import java.awt.*;
import java.util.Random;



public class MainWindow extends JFrame {
	
	private HealthPanel healthPanel;

	
	public MainWindow() {
		
		setTitle("Hangman Game");
		setSize(400,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		healthPanel = new HealthPanel(6); 
	    add(healthPanel, BorderLayout.NORTH);
	    
		setVisible(true);

	 
	}
}
