package hangman;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;


public class HealthPanel extends JPanel {
	
	private JLabel[] lifeLabels;
    private int maxHealth;
    private int livesRemain;

    public HealthPanel(int maxLives) {
        maxHealth = maxLives;
        livesRemain = maxHealth;
        setLayout(new FlowLayout());
        lifeLabels = new JLabel[maxHealth];

        for (int i = 0; i < maxHealth; i++) {
            lifeLabels[i] = new JLabel("●");
            lifeLabels[i].setForeground(Color.GREEN);
            add(lifeLabels[i]);
        }
    }

    public void removeLife() {
        if (livesRemain > 0) {
            lifeLabels[livesRemain - 1].setText("❌");
            lifeLabels[livesRemain -1].setForeground(Color.red);
            livesRemain--;//
        }
    }
    public void resetHealth() {
        for (JLabel label : lifeLabels) {
            label.setText("●");//
            label.setForeground(Color.GREEN); 
        }
        livesRemain = maxHealth; 
    }

    public int getCurrentHealth() {
        return livesRemain;//
    }

    public int getMaxHealth() {
        return maxHealth;//
    }
    
    public void decrementHealth() {
        removeLife();
        if (isDead()) {
           
            ((MainWindow) SwingUtilities.getWindowAncestor(this)).handleGameOver();
        }
    }

   
    public boolean isDead() {
        return livesRemain <= 0;
    }
		
}


//FINAL COMMIT 4/5/2024
