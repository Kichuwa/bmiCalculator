package bmiCalc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class AppWindow extends JFrame{

	/**
	 * Serial Added to suppress the not in use error.
	 */
	private static final long serialVersionUID = 1L;
	//Variable zone
	final private int width = 500, height = 300;
	final private String title = "BMI Calculator";
	private JLabel weight, heightI, heightF, bmi;
	private JTextField weightText, heightIText, heightFText, bmiText;
	private JButton calculate, quit;
	
	//Action listeners/handlers zone
	
	private class ExitHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class CalculationHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int totalHeightInches, heightInFeet, heightInInches;
			double bmiOut, weightInPounds;
			String results;
			
			weightInPounds = Double.parseDouble(weightText.getText());
			heightInFeet = Integer.parseInt(heightFText.getText());
			heightInInches = Integer.parseInt(heightIText.getText());
			
			totalHeightInches = ((heightInFeet * 12) + heightInInches);
			
			bmiOut = ((703 * weightInPounds) / Math.pow(totalHeightInches, 2));
			
			results = String.format("%.2f", bmiOut);
			
			bmiText.setText(results);
			
			if (bmiOut < 18.5) {
				//Under weight
				bmi.setText("BMI => Underweight ");
				bmiText.setBackground(Color.pink);
				
				
			} else if(bmiOut >= 18.5 && bmiOut < 25) {
				//Normal Weight
				bmi.setText("BMI => Normal Weight ");
				bmiText.setBackground(Color.green);
				
			} else if(bmiOut >= 25 && bmiOut < 30) {
				//Over Weight
				bmi.setText("BMI => Overweight ");
				bmiText.setBackground(Color.magenta);
				
			} else {
				//Obese 
				bmi.setText("BMI => Obese ");
				bmiText.setBackground(Color.red);
				
			}
			
			
			
		}
	}
	
	
	
	//Class Zone
	public AppWindow() {
		Container windowPane;
		setTitle(title);
		
		windowPane = getContentPane();
		windowPane.setLayout(new GridLayout(5, 2));
		
		
		//Labels and text boxes zone
		weight = new JLabel("Weight (pounds): ", SwingConstants.RIGHT);
		weightText = new JTextField(10);
		heightF = new JLabel("Height (feet): ", SwingConstants.RIGHT);
		heightFText = new JTextField(10);
		heightI = new JLabel("Height (inches): ", SwingConstants.RIGHT);
		heightIText = new JTextField(10);
		bmi = new JLabel("BMI: ", SwingConstants.RIGHT);
		bmiText = new JTextField(10);
		
		
		//Buttons Zone
		CalculationHandler calculationHandle = new CalculationHandler();
		calculate = new JButton("Compute BMI");
		calculate.addActionListener(calculationHandle);
		
		
		
		ExitHandler exitHandler = new ExitHandler();
		quit = new JButton("Quit");
		quit.addActionListener(exitHandler);
		
		
		
		//Pane Zone
		windowPane.add(weight);
		windowPane.add(weightText);
		windowPane.add(heightF);
		windowPane.add(heightFText);
		windowPane.add(heightI);
		windowPane.add(heightIText);
		windowPane.add(bmi);
		windowPane.add(bmiText);
		windowPane.add(calculate);
		windowPane.add(quit);
		
		
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
