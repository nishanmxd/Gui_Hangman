package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{
	
	private JButton[] alphabets;
	private WordPanel wordPanel;
	private HealthPanel healthPanel;
	private MainWindow mainWindow;
	private WordLoader wordLoader;
	
	public ButtonPanel(WordPanel wordPanel, HealthPanel healthPanel, MainWindow mainWindow, WordLoader wordLoader) {
		
		this.wordPanel = wordPanel;
		this.healthPanel = healthPanel;
		this.mainWindow = mainWindow;
		this.wordLoader = wordLoader;
		
		setLayout(new GridLayout(6,6)); //adding alphabets into 6 rows and 6 columns
		
		alphabets = new JButton[26];
		
		for(char x = 'A'; x<= 'Z'; x++) {
			
			int index = x - 'A';
			alphabets[index] = new JButton(String.valueOf(x));			 
			alphabets[index].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JButton buttonClicked = (JButton) e.getSource();
				String letter = buttonClicked.getText();
				
				buttonClicked.setEnabled(false);
				boolean guessedRight = wordPanel.guess(letter);
				
				if(!guessedRight) {
					boolean gameOver = healthPanel.removeLife();
					
					if(gameOver) {
						gameOver();
						
						
					}else {
						
					}
				}
				
				checkGameStatus();
				
			}			
						
		});	
		 
		add(alphabets[index]);
		
		}
		
		
	}
	
		private void gameOver() {
			
			String correctWord = wordPanel.getWord();
			int choise = JOptionPane.showConfirmDialog(null, "Game Over! The Correct Word is: " + correctWord + ". Would you like to try again?" , "Game Over" , JOptionPane.YES_NO_OPTION);
			
			if(choise == JOptionPane.YES_OPTION) {
				mainWindow.restartGame();
			}
			else{
				mainWindow.dispose();
				System.exit(0);
			}
		}
		
		private void checkGameStatus() {
			
			if(wordPanel.isCompletelyGuessed()) {
				int choise = JOptionPane.showConfirmDialog(null, "You guessed the word correctly! Would you like to restart?", "You Won", JOptionPane.YES_NO_OPTION);
				
				if(choise == JOptionPane.YES_OPTION) {
					mainWindow.restartGame();
				}
				else {
					mainWindow.dispose();
					System.exit(0);
				}
			}
				
			
		}
		
		public void resetButtons() {	
		
	        for (JButton button : alphabets) {
	            button.setEnabled(true);
	            
	        }
	
	}
}

