package HomeTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.opengl.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;

/**
 *
 * @author Mohamed
 */
/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class FocusExample extends JFrame {

    public static void main(String[] args) {
        final FocusExample app = new FocusExample();
// show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        app.setVisible(true);
                    }
                }
        );
    }

    public FocusExample() {
//set the JFrame title
        super("Focus Example");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//only three JOGL lines of code ... and here they are
        GLCanvas glcanvasWest = new GLCanvas();
        FocusExampleDisplay fed1
                = new FocusExampleDisplay("Red", glcanvasWest);

        glcanvasWest.addGLEventListener(fed1);
        glcanvasWest.addFocusListener(fed1);

        GLCanvas glcanvasEast = new GLCanvas();
        FocusExampleDisplay fed2
                = new FocusExampleDisplay("Blue", glcanvasEast);
        glcanvasEast.addGLEventListener(fed2);
        glcanvasEast.addFocusListener(fed2);

        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
//add the GLCanvases just like we would any Components
        getContentPane().add(glcanvasWest, BorderLayout.WEST);
        getContentPane().add(glcanvasEast, BorderLayout.EAST);
        add(new JButton("Press Me"), BorderLayout.NORTH);
        glcanvasEast.setSize(200, 200);
        glcanvasEast.setLocation(275, 50);
        glcanvasWest.setSize(200, 200);
        glcanvasWest.setLocation(25, 50);
        setSize(500, 300);
//center the JFrame on the screen
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}

