package hangman;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel {
	private ArrayList<String> wordList; 
    private JLabel wordL; 
    private String word; 

public WordPanel() {
	wordL = new JLabel();
    wordL.setFont(new Font("Arial", Font.PLAIN, 20));
    add(wordL);
    loadWordsFromFile("C:/Users/Osaja Jafri/git/gui_coursework/src/hangman/words.txt");
    setRandomWord();
}



private void loadWordsFromFile(String filename) {
    wordList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Osaja Jafri/git/gui_coursework/src/hangman/words.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        wordList.add(line.trim());
    }
} catch (IOException e) {
    System.err.println("Error loading words from file: " + e.getMessage());
    }
}


void setRandomWord() {
    if (!wordList.isEmpty()) {
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        word = wordList.get(index); 
        wordL.setText(generateHiddenWord(word)); 
    } else {
        wordL.setText("No words loaded.");
    }
}



private String generateHiddenWord(String word) {
    return word.replaceAll("[a-zA-Z]", "_"); 
}


public boolean guessLetter(char letter) {
    boolean correctGuess = false;
    char[] currentWordArray = word.toCharArray();
    char[] hiddenWordArray = wordL.getText().toCharArray();

    for (int i = 0; i < currentWordArray.length; i++) {
        if (Character.toUpperCase(currentWordArray[i]) == Character.toUpperCase(letter)) {
            hiddenWordArray[i] = currentWordArray[i];
            correctGuess = true;
        }
    }

    wordL.setText(new String(hiddenWordArray)); 

    return correctGuess;
}

 boolean wordGuessed() {
	 return !wordL.getText().contains("_");
 }
 
 public String getWord() {
	 return word;
 }
 
}
//FINAL COMMIT 4/5/2024
	
	








