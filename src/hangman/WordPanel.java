package hangman;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel{
	
	private JLabel wordLabel;
	private String word;  //currrentword
	private StringBuilder emptyWord;  //displayedword
	
	public WordPanel(String word) { 	
		
		 setLayout(new BorderLayout());
		 this.word = word.toLowerCase();
		 emptyWord = new StringBuilder(getMaskedWord(word));
	     wordLabel = new JLabel(getMaskedWord(word), SwingConstants.CENTER);
	     wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
	     add(wordLabel, BorderLayout.CENTER);
		
	}
	
	public void update(String newWord) {
		
		word = newWord.toLowerCase();
		emptyWord = new StringBuilder(getMaskedWord(newWord));
        wordLabel.setText(getMaskedWord(word));
        
    }
	
	private String getMaskedWord(String word) {
		
        StringBuilder maskedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            maskedWord.append("_ ");
        }
        
        return maskedWord.toString().trim();
    }
	
	

	
	public boolean guess(String letters) {	
		boolean guessedRight = false;
		
		for(int i=0; i<word.length(); i++){
			if(String.valueOf(word.charAt(i)).equalsIgnoreCase(letters)) {
				emptyWord.setCharAt(i * 2, letters.charAt(0));
				guessedRight = true;
			}
		}
		
		wordLabel.setText(emptyWord.toString().replace("", ""));
        return guessedRight;
		
	}
	
	public boolean isCompletelyGuessed() {
		
		return !emptyWord.toString().contains("_");
	}
	
	public String getWord() {
		
		return word;
	}
	

}
