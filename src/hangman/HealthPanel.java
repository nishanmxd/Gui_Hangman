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
	            guessLabels[i] = new JLabel(String.valueOf(i+1)); // this adds the green circles indicating remaining guess
	            guessLabels[i].setForeground(Color.GREEN);
	            guessLabels[i].setFont(new Font("Arial", Font.PLAIN, 20));
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
