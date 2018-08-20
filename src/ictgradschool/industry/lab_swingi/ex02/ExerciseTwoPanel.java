package ictgradschool.industry.lab_swingi.ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 * <p>
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseTwoPanel extends JPanel implements ActionListener {
    private JTextField first;
    private JTextField second;
    private JTextField result;

    private JButton badd;
    private JButton bsubtract;

    private JLabel lresult;

    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseTwoPanel() {
        setBackground(Color.white);
//        create JTextField,Jbutton and Jlabel
        this.first = new JTextField(10);
        this.second = new JTextField(10);
        this.badd = new JButton("Add");
        this.bsubtract = new JButton("Subtract");
        this.lresult = new JLabel("Result");
        this.result = new JTextField(10);

//        add to JPanel
        this.add(first);
        this.add(second);
        this.add(badd);
        this.add(bsubtract);
        this.add(lresult);
        this.add(result);

//      add action
        badd.addActionListener(this);
        bsubtract.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double f=Double.parseDouble(first.getText());
        double s=Double.parseDouble(second.getText());

        double add=f+s;
        double sub=f-s;
        if (e.getSource()==badd) {
            result.setText(String.valueOf(roundTo2DecimalPlaces(add)));
        }else if (e.getSource()==bsubtract){
            result.setText(String.valueOf(roundTo2DecimalPlaces(sub)));
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