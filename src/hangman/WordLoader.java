package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class WordLoader {
	
	 private ArrayList<String> wordsList = new ArrayList<>();
	 
	 public WordLoader(String name)  {
		 
		 loadWords("words.txt");
		 
	 }

	private void loadWords(String name) {
		
		try{BufferedReader reader;	
			reader = new BufferedReader(new FileReader(name));
			String line;
			while((line = reader.readLine()) != null) {
				wordsList.add(line.trim());
				
			}reader.close();
		} catch (IOException e) {
			System.err.println("Error loading words from file: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public String randomWord() {
		
		if (wordsList.isEmpty()) {
            return null; 
        }
		
		Random random = new Random();
		
		int word = random.nextInt(wordsList.size());
		return wordsList.get(word);
		
	}
}
