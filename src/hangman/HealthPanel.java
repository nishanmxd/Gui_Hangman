package hangman;
import javax.swing.*;
import java.awt.*;


public class HealthPanel extends JPanel{
	
	private int guessesLeft;
    private JLabel[] guessLabels;
    
	public HealthPanel(int allowedGuesses) {
		
		this.guessesLeft = allowedGuesses;
		setLayout(new FlowLayout());
		
	
		guessLabels = new JLabel[allowedGuesses];
		 
	        for (int i = 0; i < allowedGuesses; i++) {
	            guessLabels[i] = new JLabel("O"); // this adds the green circles indicating remaining guess
	            guessLabels[i].setForeground(Color.GREEN);
	            add(guessLabels[i]);
	   
	        	}
	    }
	
	public boolean removeLife() {
        if (guessesLeft > 0) {
            guessLabels[guessesLeft - 1].setForeground(Color.RED); // this changes color of last label to red for wrong inputs
            guessesLeft--;
        }
        return guessesLeft == 0; // returns true if no remaining guesses left
    }
	
	
	
}
