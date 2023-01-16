package HomeTask;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class FocusExampleDisplay implements GLEventListener, FocusListener {

    GLCanvas glcanvas = null;
    float red = 0.0f;
    float green = 0.0f;
    float blue = 0.0f;

    public FocusExampleDisplay(String color, GLCanvas glcanvas) {
        if (color.equals("Red")) {
            red = 1.0f;
        } else {
            blue = 1.0f;
        }
        this.glcanvas = glcanvas;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 500, 0, 300, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(
                red,
                green,
                blue,
                1.0f
        );
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

    ////////////////////////////////
// FocusListener Implementation
    @Override
    public void focusGained(FocusEvent fe) {
        green = 1.0f;
        glcanvas.repaint();
    }

    @Override
    public void focusLost(FocusEvent fe) {
        green= 0.0f;
        glcanvas.repaint();
    }

}