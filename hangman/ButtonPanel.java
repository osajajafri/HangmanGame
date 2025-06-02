package hangman;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonPanel extends JPanel {	
	 WordPanel wP;
	 JButton [] letterBtns;
	
	public ButtonPanel(WordPanel wordPanel) {
        this.wP = wordPanel;

        setLayout(new GridLayout(3, 9)); 
        letterBtns = new JButton[26];

        for (int i = 0; i < 26; i++) {
            final char letter = (char) ('A' + i);
            JButton button = new JButton(String.valueOf(letter));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guessLetter(letter, button); 
                }
            });

            letterBtns[i] = button;
            add(button);
        }
    }

    public void resetButtons() {
        for (JButton button : letterBtns) {
            button.setEnabled(true); 
        }
    }
    private void guessLetter(char letter, JButton button) {
        boolean guessedCorrectly = wP.guessLetter(letter); 
        if (guessedCorrectly) {
            if (wP.wordGuessed()) {
                ((MainWindow) SwingUtilities.getWindowAncestor(this)).handleGameWon();
            }
        } else {
            ((MainWindow) SwingUtilities.getWindowAncestor(this)).handleIncorrectGuess();
        }
        button.setEnabled(false); 
    }
    
}
	  
//FINAL COMMIT 4/5/2024