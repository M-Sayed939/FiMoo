package Sudoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MySudoku {
    public static byte[][] sudoku = new byte[729][82];
    public static byte step = 0;

    private static final int WindowWidth = 777;
    private static final int WindowHeight = 636;

    public static void ShowGUI() {
        Methods.start(sudoku);

        final byte border = 14;
        JFrame f = new JFrame("Sudoku v3.0");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("sudoku.png"));
        } catch (IOException e) {
        }
        f.setResizable(false);
        f.setIconImage(image);
        f.setSize(WindowWidth, WindowHeight);
        f.setLocation(0, 0);
        f.setLayout(new BorderLayout());

        f.add(new SPanel(new Dimension(WindowWidth, border)), BorderLayout.NORTH);
        f.add(new SPanel(new Dimension(WindowWidth, border)), BorderLayout.SOUTH);
        f.add(new SPanel(new Dimension(border, WindowHeight)), BorderLayout.EAST);
        f.add(new SPanel(new Dimension(0, WindowHeight)), BorderLayout.WEST);

        DisplayPanel dp = new DisplayPanel();
        dp.setBackground(Color.WHITE);
        f.add(dp, BorderLayout.CENTER);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });
    }

}