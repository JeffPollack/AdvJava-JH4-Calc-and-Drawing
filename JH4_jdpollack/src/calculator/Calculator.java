package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {

	public static final int WIDTH = 450;
	public static final int HEIGHT = 300;

	JButton[] button = new JButton[16];
	JTextField calculatorDisplay = new JTextField();
	String[] buttonString = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=", "clear" };
	Font font = new Font("SERIF", Font.BOLD, 32);
	double firstOperand = 0;
	double secondOperand = 0;
	String operator = " ";

	public Calculator() {
		super();
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		calculatorDisplay.setBackground(Color.yellow);
		calculatorDisplay.setEditable(false);
		add(calculatorDisplay, BorderLayout.NORTH);

		JPanel calcButtonPanel = new JPanel();
		calcButtonPanel.setBackground(Color.lightGray);
		calcButtonPanel.setLayout(new GridLayout(4, 4, 4, 4));

		for (int i = 0; i < 10; i++) {
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].setBackground(Color.cyan);
			button[i].addActionListener(this);
			calcButtonPanel.add(button[i]);
		}
		for (int i = 10; i < buttonString.length; i++) {
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].setBackground(Color.red);
			button[i].addActionListener(this);
			calcButtonPanel.add(button[i]);
		}
		add(calcButtonPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String label = ae.getActionCommand();
		String currText = calculatorDisplay.getText();

		switch (label) {
		case "+":
		case "-":
		case "*":
		case "/":
			operator = label;
			firstOperand = Double.parseDouble(currText);
			calculatorDisplay.setText("");
			break;
		case "=":
			secondOperand = Double.parseDouble(currText);
			if ("+".equals(operator)) {
				calculatorDisplay.setText(Double.toString(firstOperand + secondOperand));
			} else if ("-".equals(operator)) {
				calculatorDisplay.setText(Double.toString(firstOperand - secondOperand));
			} else if ("*".equals(operator)) {
				calculatorDisplay.setText(Double.toString(firstOperand * secondOperand));
			} else if ("/".equals(operator)) {
				calculatorDisplay.setText(Double.toString(firstOperand / secondOperand));
			}
			break;
		case "clear":
			operator = " ";
			firstOperand = 0;
			secondOperand = 0;
			calculatorDisplay.setText("");
			break;
		default:
			calculatorDisplay.setText(currText + label);
			break;
		}
	}
}
