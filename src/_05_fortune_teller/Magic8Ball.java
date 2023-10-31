package _05_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….

	// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"

	// 3. Print out this variable

	// 4. Get the user to enter a question for the 8 ball

	// 5. If the random number is 0

	// -- tell the user "Yes"

	// 6. If the random number is 1

	// -- tell the user "No"

	// 7. If the random number is 2

	// -- tell the user "Maybe you should ask Google?"

	// 8. If the random number is 3

	// -- write your own answer
	public void fortune() {
		Random rand = new Random();
		int randOutput = rand.nextInt(4);
		System.out.println(randOutput);
		JOptionPane.showInputDialog("Ask the 8Ball a question.");
		
		if (randOutput == 0) {
			JOptionPane.showMessageDialog(null, "Yes");
		} else if (randOutput == 1) {
			JOptionPane.showMessageDialog(null, "No");
		} else if (randOutput == 2) {
			JOptionPane.showMessageDialog(null, "Maybe you should ask Google?");
		} else {
			JOptionPane.showMessageDialog(null, "That's Really Weird");
		}
		
		
	}

}
