package _08_pig_latin;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatin implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField english = new JTextField();
	JTextField latin = new JTextField();
	JButton toLatin = new JButton();
	JButton toEnglish = new JButton();
	static PigLatinTranslator translator = new PigLatinTranslator();

	public void run() {
		createUI();
		
	}
	
	public void createUI() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 100));
		frame.setTitle("Pig Latin Translater");
		
		panel.setSize(new Dimension(600, 100));
		frame.add(panel);
		
		english.setPreferredSize(new Dimension(200, 30));
		panel.add(english);
		
		toLatin.setPreferredSize(new Dimension(80, 45));
		toLatin.setText(">>");
		toLatin.addActionListener(this);
		panel.add(toLatin);
		
		toEnglish.setPreferredSize(new Dimension(80, 45));
		toEnglish.setText("<<");

		toEnglish.addActionListener(this);
		panel.add(toEnglish);
		
		latin.setPreferredSize(new Dimension(200, 30));
		panel.add(latin);
		
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		String engText = english.getText();
		System.out.println(engText);
		String latText = latin.getText();
		System.out.println(latText);
		
		if (buttonPressed == toLatin) {
			latin.setText(PigLatinTranslator.translateEnglishToPigLatin(engText));
			
		}
		
		if (buttonPressed == toEnglish) {
			english.setText(PigLatinTranslator.translatePigLatinToEnglish(latText));
			
		}
		
	}

}
