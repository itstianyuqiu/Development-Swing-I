package ictgradschool.industry.lab11.ex02;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExerciseTwoPanel}.
 */
public class ExerciseTwoFrame extends JFrame {

    /**
     * Creates a new ExerciseFiveFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public ExerciseTwoFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExerciseTwoPanel frameContent = new ExerciseTwoPanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExerciseTwoFrame frame = new ExerciseTwoFrame("Exercise Two: Calculator", 100, 100, 800, 100);
                frame.setVisible(true);
            }
        });
    }

}
