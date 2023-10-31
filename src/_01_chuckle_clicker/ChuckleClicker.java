package _01_chuckle_clicker;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton joke;
	JButton punchline;
	final static int WIDTH = 300;
	final static int HEIGHT = 150;
	
	public ChuckleClicker() {
		// TODO Auto-generated constructor stub
	}

//	public void main(String[] args) {
////		makeButtons();
//
//	}
	
	public void makeButtons() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("ChuckleClicker");
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		joke = new JButton();
		punchline = new JButton();
		
		panel.add(joke);
		joke.setPreferredSize(new Dimension(100, 40));
		joke.setText("Joke");
//		joke.addActionListener((ActionListener) this);
		joke.addActionListener(this);
		
		panel.add(punchline);
		punchline.setPreferredSize(new Dimension(150, 40));
		punchline.setText("Punchline");
		punchline.addActionListener(this);
		
		
		frame.pack();
	}

public void actionPerformed(ActionEvent e) {
	if(e.getSource() == joke) {
		JOptionPane.showMessageDialog(frame, "Why did the chicken cross the road?");
	}
	if(e.getSource() == punchline) {
		JOptionPane.showMessageDialog(frame, "To get to the other side.");
	}
	
}



}
