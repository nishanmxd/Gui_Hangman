package hangman;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class MainWindow extends JFrame {
	
	private HealthPanel healthPanel;
	private WordPanel wordPanel;
	
	
	public MainWindow() {
		
		setTitle("Hangman Game");
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		WordLoader wordLoader = new WordLoader("words.txt");
		String newWord = wordLoader.randomWord();
		
		wordPanel = new WordPanel(newWord);
		add(wordPanel, BorderLayout.CENTER);
	
		
		healthPanel = new HealthPanel(6); 
		add(healthPanel, BorderLayout.NORTH);
		
		
		
		setVisible(true);

	 
	}
}
