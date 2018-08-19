package ictgradschool.industry.lab_swingi.ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI app that does BMI calculations.
 */
public class ExerciseOnePanel extends JPanel implements ActionListener {

    // TODO Declare JTextFields and JButtons as instance variables here.
    private JButton calculateBMIButton;
    private JButton calculateHealthyWeight;
    private JTextField height;
    private JTextField weight;
    private JTextField bmi;
    private JTextField maxHealthyWeight;

    /**
     * Creates a new ExerciseOnePanel.
     */
    public ExerciseOnePanel() {
        setBackground(Color.white);

        // TODO Construct JTextFields and JButtons.
        // HINT: Declare them as instance variables so that other methods in this class (e.g. actionPerformed) can
        // also access them.
        this.height = new JTextField(15);
        this.weight = new JTextField(15);
        this.bmi = new JTextField(15);
        this.maxHealthyWeight = new JTextField(15);

        this.calculateBMIButton = new JButton("Calculate BMI");
        this.calculateHealthyWeight = new JButton("Calculate Healthy Weight");

        // TODO Declare and construct JLabels
        // Note: These ones don't need to be accessed anywhere else so it makes sense just to declare them here as
        // local variables, rather than instance variables.
        JLabel lheight = new JLabel("Height in metres: ");
        JLabel lweight = new JLabel("Weight in kilograms: ");
        JLabel lbmi = new JLabel("Your Body Mass Index (BMI) is: ");
        JLabel lmaxHealthyWeight = new JLabel("Maximum Healthy Weight for your Height: ");
        // TODO Add JLabels, JTextFields and JButtons to window.
        // Note: The default layout manager, FlowLayout, will be fine (but feel free to experiment with others if you want!!)
        this.add(lheight);
        this.add(height);
        this.add(lweight);
        this.add(weight);
        this.add(calculateBMIButton);
        this.add(lbmi);
        this.add(bmi);
        this.add(calculateHealthyWeight);
        this.add(lmaxHealthyWeight);
        this.add(maxHealthyWeight);
        // TODO Add Action Listeners for the JButtons
        calculateBMIButton.addActionListener(this);
        calculateHealthyWeight.addActionListener(this);
    }


    /**
     * When a button is clicked, this method should detect which button was clicked, and display either the BMI or the
     * maximum healthy weight, depending on which JButton was pressed.
     */
    public void actionPerformed(ActionEvent event) {

        // TODO Implement this method.
        // Hint #1: event.getSource() will return the button which was pressed.
        // Hint #2: JTextField's getText() method will get the value in the text box, as a String.
        // Hint #3: JTextField's setText() method will allow you to pass it a String, which will be diaplayed in the text box.
        double h = Double.valueOf(height.getText());
        double w = Double.valueOf(weight.getText());

        double cbmi = w / (h * h);
        double cmhw = 24.9 * h * h;

        if (event.getSource() == calculateBMIButton) {
            bmi.setText(String.valueOf(roundTo2DecimalPlaces(cbmi)));
        } else if (event.getSource() == calculateHealthyWeight) {
            maxHealthyWeight.setText(String.valueOf(roundTo2DecimalPlaces(cmhw)));
        }
    }


    /**
     * A library method that rounds a double to 2dp
     *
     * @param amount to round as a double
     * @return the amount rounded to 2dp
     */
    private double roundTo2DecimalPlaces(double amount) {
        return ((double) Math.round(amount * 100)) / 100;
    }

}