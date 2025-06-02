package hangman;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class MainWindow extends JFrame{
	
	public HealthPanel healthPanel;
	public WordPanel wordPanel;
	public ButtonPanel btnPanel;
	public ArrayList<String> wordList;
	public Loader loader;
	public  MainWindow() { 
		
		setTitle("Hangman");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		loader = new Loader("C:/Users/Osaja Jafri/git/gui_coursework/src/hangman/words.txt");
		String randomWord = loader.getRandomWord();
		
		wordPanel = new WordPanel();
		add(wordPanel, BorderLayout.CENTER);
		
		healthPanel = new HealthPanel(6);
		add(healthPanel, BorderLayout.NORTH);
		
		btnPanel = new ButtonPanel(wordPanel);
        add(btnPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	
	}
	
	
	public void handleGameWon() {
        JOptionPane.showMessageDialog(this, "Congratulations! You've won the game!", "Game Won", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }
	public void handleGameOver() {
        JOptionPane.showMessageDialog(this, "Game Over! You've run out of lives.");
 
	}
	
	
	 public void handleIncorrectGuess() {
	        healthPanel.decrementHealth(); 
	        if (healthPanel.isDead()) {
	            JOptionPane.showMessageDialog(this, "You've lost the game! The word was: " + wordPanel.getWord(), "Game Over", JOptionPane.ERROR_MESSAGE);
	            resetGame();
	        }
	    }

	
	    private void resetGame() {
	        healthPanel.resetHealth(); 
	        wordPanel.setRandomWord(); 
	        btnPanel.resetButtons(); 
	    }
	    
	    
  

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
            
        });
    }

}
class Loader{
	private ArrayList<String> wordList;

    
    public Loader(String filename) {
        wordList = new ArrayList<>();
        loadWords(filename);
    }

   
    private void loadWords(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Osaja Jafri/git/gui_coursework/src/hangman/words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public String getRandomWord() {
        if (!wordList.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(wordList.size());
            return wordList.get(index);
        } else {
            return null;
        }
    }
}
	
//FINAL COMMIT 4/5/2024
