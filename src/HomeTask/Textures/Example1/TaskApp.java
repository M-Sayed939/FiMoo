package HomeTask.Textures.Example1;
import com.sun.opengl.util.*;
import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;




public class TaskApp extends JFrame {

        public static void main(String[] args) {
            new TaskApp();
        }


        public TaskApp() {
            GLCanvas glcanvas;
            Animator animator;

            AnimGLEventListener4 listener = new AnimGLEventListener4();
            glcanvas = new GLCanvas();
            glcanvas.addGLEventListener(listener);
            glcanvas.addKeyListener(listener);
            getContentPane().add(glcanvas, BorderLayout.CENTER);
            animator = new FPSAnimator(15);
            animator.add(glcanvas);
            animator.start();

            setTitle("Anim Test");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700, 700);
            setLocationRelativeTo(null);
            setVisible(true);
            setFocusable(true);
            glcanvas.requestFocus();
        }
    }

