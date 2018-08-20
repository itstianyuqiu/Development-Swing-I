package ictgradschool.industry.lab_swingi.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Displays an animated balloon.
 */
public class ExerciseFourPanel extends JPanel implements ActionListener, KeyListener {

    private ArrayList<Balloon> arr;
    private JButton moveButton;
    private Timer timer;

    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseFourPanel() {
        setBackground(Color.white);

        this.arr=new ArrayList<>();
        Balloon balloon1 = new Balloon(30, 60);
        Balloon balloon2=new Balloon(20,40);
        Balloon balloon3=new Balloon(50,80);
        arr.add(balloon1);
        arr.add(balloon2);
        arr.add(balloon3);
//        this.moveButton = new JButton("Move balloon");
//        this.moveButton.addActionListener(this);
//        this.add(moveButton);

        this.addKeyListener(this);

        this.timer = new Timer(0, this);

    }

    /**
     * Moves the balloon and calls repaint() to tell Swing we need to redraw ourselves.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

//        balloon.move();

        // Sets focus to the panel itself, rather than the JButton. This way, the panel can continue to generate key
        // events even after we've clicked the button.
        requestFocusInWindow();

        repaint();
    }

    /**
     * Draws any balloons we have inside this panel.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        arr.get(0).draw(g);
        arr.get(1).draw(g);
        arr.get(2).draw(g);

        // Sets focus outside of actionPerformed so key presses work without pressing the button
        requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        arr.get(0).move();
        arr.get(1).move();
        arr.get(2).move();
        repaint();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            arr.get(0).setDirection(Direction.Left);
            arr.get(1).setDirection(Direction.Left);
            arr.get(2).setDirection(Direction.Left);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            arr.get(0).setDirection(Direction.Right);
            arr.get(1).setDirection(Direction.Right);
            arr.get(2).setDirection(Direction.Right);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            arr.get(0).setDirection(Direction.Down);
            arr.get(1).setDirection(Direction.Down);
            arr.get(2).setDirection(Direction.Down);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            arr.get(0).setDirection(Direction.Up);
            arr.get(1).setDirection(Direction.Up);
            arr.get(2).setDirection(Direction.Up);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            arr.get(0).setDirection(Direction.Stop);
            arr.get(1).setDirection(Direction.Stop);
            arr.get(2).setDirection(Direction.Stop);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}