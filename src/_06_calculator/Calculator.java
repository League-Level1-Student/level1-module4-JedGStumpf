package _06_calculator;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame;
	JPanel panel;
	JPanel inputPanel;
	JPanel buttonPanel;
	JPanel labelPanel;
	JButton add;
	JButton subtract;
	JButton multiply;
	JButton divide;
	JLabel result;
	JTextField num1;
	JTextField num2;

	double firstNum;
	double secondNum;
	
	public void run() {
		setScreen();
	}
	
	public void setScreen() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 400);
		frame.setTitle("Simple Calculator");
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setSize(500, 400);
		frame.add(panel);
		
		inputPanel = new JPanel();
		num1 = new JTextField();
		num1.setPreferredSize(new Dimension(100, 25));
		num2 = new JTextField();
		num2.setPreferredSize(new Dimension(100, 25));
		inputPanel.add(num1);
		inputPanel.add(num2);
		panel.add(inputPanel);
 
		buttonPanel = new JPanel();
		add = new JButton();
		add.setText("ADD");
		add.addActionListener(this);
		buttonPanel.add(add);
		
		subtract = new JButton();
		subtract.setText("SUBTRACT");
		subtract.addActionListener(this);
		buttonPanel.add(subtract);
		
		multiply = new JButton();
		multiply.setText("MULTIPLY");
		multiply.addActionListener(this);
		buttonPanel.add(multiply);
		
		divide = new JButton();
		divide.setText("DIVIDE");
		divide.addActionListener(this);
		buttonPanel.add(divide);
		
		panel.add(buttonPanel);
		
		labelPanel = new JPanel();
		result = new JLabel();
//		result.setPreferredSize(new Dimension(100, 300));
		result.setText("0");
		result.setSize(500, 50);
		labelPanel.add(result);
		
		panel.add(labelPanel);
		
		frame.pack();
	}
	
	
	public double add(double firstNum, double secondNum) {
		return firstNum + secondNum;
	}
	
	public double subtract(double firstNum, double secondNum) {
		return firstNum - secondNum;
	}
	
	public double multiply(double firstNum, double secondNum) {
		return firstNum * secondNum;
	}
	
	public double divide(double firstNum, double secondNum) {
		if (secondNum == 0) {
			JOptionPane.showMessageDialog(null, "Can Not Divide by Zero ");
			return 0;
		}
		return firstNum / secondNum;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		double number1;
		double number2;
		
		String first = num1.getText();
		String second = num2.getText();

		if (num1.getText().equals("") || num2.getText().equals("")) {
			result.setText("Please enter valid numbers");

		} else {
			number1 = Double.valueOf(first);
			number2 = Double.valueOf(second);
			
			if (buttonPressed == add) {
				result.setText(String.valueOf(add(number1, number2)));
			} else if (buttonPressed == subtract) {
				result.setText(String.valueOf(subtract(number1, number2)));
			} else if (buttonPressed == multiply) {
				result.setText(String.valueOf(multiply(number1, number2)));
			} else if (buttonPressed == divide) {
				if (number2 == 0.0) {
					result.setText("Please enter a valid divisor");
				} else {
					result.setText(String.valueOf(divide(number1, number2)));
				}
				
			}
			num1.setText(null);
			num2.setText(null);
		}
		
		
	}
	
	

}
