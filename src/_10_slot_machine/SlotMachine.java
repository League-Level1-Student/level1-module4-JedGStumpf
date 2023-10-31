package _10_slot_machine;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	
	String imageFile1 = "ace_club.png";
	String imageFile2 = "ace_diamond.png";
	String imageFile3 = "ace_heart.png";
	
	String one;
	String two;
	String three;
	
	JFrame frame;
	JPanel imagePanel;
	JPanel spinPanel;
	JButton spin;
	
	JLabel moneyLabel;
	int money = 1000;
	

	public void run() {
		buildUI();
	}
	
	public void buildUI() {
		frame = new JFrame();
		frame.setSize(1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Slot Machine");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		imagePanel = new JPanel();
		imagePanel.setSize(new Dimension(1200, 700));
		imagePanel.setBackground(Color.BLACK);
		
		
		for (int i = 0; i <= 2; i++) {
			if (i == 0) {
				one = displayImages();
			}
			if (i == 1) {
				two = displayImages();
			}
			if (i == 2) {
				three = displayImages();
			}
		}
		
		spinPanel = new JPanel();
		spinPanel.setSize(new Dimension(1200, 200));
		spinPanel.setBackground(Color.BLACK);
		spinPanel.setLayout(new GridLayout(1, 3, 15, 15));
		
		
		moneyLabel = new JLabel();
		moneyLabel.setText("$100 Per Spin" + "\n" + "You Have $"+money);
		moneyLabel.setPreferredSize(new Dimension(500, 100));
		spinPanel.add(moneyLabel);
		
		spin = new JButton("SPIN");
		spin.setPreferredSize(new Dimension(75, 750));
		spin.addActionListener(this);
		spinPanel.add(spin);
		
		frame.add(imagePanel);
		frame.add(spinPanel);
		frame.setVisible(true);
		
	}
	
	private String displayImages() {
		Random rand = new Random();
		int choice = rand.nextInt(3);
		
		if (choice == 0) {
			try {
				imagePanel.add(createLabelImage(imageFile1));
				return imageFile1;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (choice == 1) {
			try {
				imagePanel.add(createLabelImage(imageFile2));
				return imageFile2;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (choice == 2) {
			try {
				imagePanel.add(createLabelImage(imageFile3));
				return imageFile3;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return "";
	}
	
	public boolean winCheck(String file1, String file2, String file3) {
		if (file1 == file2 && file2 == file3) {
			money += 500;
			
			return true;
		}

		money -= 100;

		return false;
	}
	
	
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (winCheck(one, two, three)) {
			JOptionPane.showMessageDialog(frame, "WINNER!!!!");
			
		} else {
			JOptionPane.showMessageDialog(frame, "Sorry...");
		}
		frame.removeAll();
		frame.dispose();
		run();
	}

}
