package _03_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label;
	char currentLetter;
	final static int WIDTH = 300;
	final static int HEIGHT = 150;

	void setup(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentLetter = generateRandomLetter();
		label = new JLabel();
		label.setText(Character.toString(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		panel.add(label);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame.add(panel);
		frame.pack();
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You Pressed " + e.getKeyChar());
		if (e.getKeyChar() == currentLetter) {
			System.out.println("CORRECT");
			panel.setBackground(Color.GREEN);
		} else {
			System.out.println("INCORRECT");
			panel.setBackground(Color.RED);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText(Character.toString(currentLetter));
		
		
	}
	
}
