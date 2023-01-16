package CardGame;

import HomeTask.Textures.AnimListener;
import HomeTask.Textures.Example1.Anim;
import HomeTask.Textures.Example1.AnimGLEventListener3;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

        public static void main(String[] args) {
            new HomeTask.Textures.Example1.Anim(new AnimGLEventListener3());
        }

        public Test(AnimListener aListener) {
            GLCanvas glcanvas;
            Animator animator;

            AnimListener listener = aListener;
            glcanvas = new GLCanvas();
            glcanvas.addGLEventListener(listener);
            glcanvas.addKeyListener(listener);
            getContentPane().add(glcanvas, BorderLayout.CENTER);
            animator = new FPSAnimator(15);
            animator.add(glcanvas);
            animator.start();

            setTitle("Anim Test");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(900, 500);
            setLocationRelativeTo(null);
            setVisible(true);
            setFocusable(true);
            glcanvas.requestFocus();
        }
}
