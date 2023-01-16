package Tasks;

import com.sun.opengl.util.FPSAnimator;
import HomeTask.Textures.AnimListener;
import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class SimpleApp extends JFrame {
    GLCanvas glcanvas;
    SimpleGLEventListener listener = new SimpleGLEventListener();
    static FPSAnimator animator;

    public SimpleApp() {
        super("Simple Face");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        animator = new FPSAnimator(glcanvas,60);

        add(glcanvas, BorderLayout.CENTER);
        setSize(600, 600);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleApp();
        animator.start();
    }
}