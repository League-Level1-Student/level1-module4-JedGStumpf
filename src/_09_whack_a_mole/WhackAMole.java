package _09_whack_a_mole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton theMole;
	int trys = 0;
	int correct = 0;
	
	public void run() {
		createUI();
	}
	
	public void createUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 800);
		frame.setTitle("Whack A Mole");
		
		
		panel = new JPanel();
		panel.setSize(new Dimension(450, 750));
		panel.setLayout(new GridLayout(8, 3, 5, 5));
		panel.setBackground(Color.PINK);
		frame.add(panel);
		

		createButtons(getRandom(24));
		frame.setVisible(true);
	}
	
	public int getRandom(int randomNum) {
		Random rand = new Random();
		
		return rand.nextInt(randomNum);
	}
	
	public int createButtons(int moleLocation) {
		int moleButton = 0;
		for (int i = 0; i < 12; i++) {
			button = new JButton();
			button.setPreferredSize(new Dimension(60, 60));
			if (i == moleLocation) {
				moleButton = moleLocation;
				theMole = new JButton();
				theMole.addActionListener(this);
				panel.add(theMole);
				
				
			} else {
				button.addActionListener(this);
				panel.add(button);
			}

		}
		
		return moleButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == theMole){
			correct++;
			trys++;
			speak("Nice");
			frame.removeAll();
			frame.dispose();
			run();
		} else {
			trys++;
			speak("Nope");
		}
		
		isWinner(correct, trys);
		
		
	}
	
	public void isWinner(int correct, int trys) {
		if (trys == 10) {
			if (correct >= 3) {
				JOptionPane.showMessageDialog(null, "Winner " + correct + " Moles Wacked of " + trys + " trys.");
			} else {
				JOptionPane.showMessageDialog(null, "Not A Winner " + correct + " Moles Wacked of " + trys + " trys.");
			}
			speak("Next Game");
			frame.removeAll();
			trys = 0;
			correct = 0;
			
			run();
		} 
	}
	
	
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }

}
