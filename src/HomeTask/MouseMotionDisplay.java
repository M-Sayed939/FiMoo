package HomeTask;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class MouseMotionDisplay implements GLEventListener, MouseMotionListener {

    int xPosition = 50;
    int yPosition = 50;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        red = 0.5f;
        green = 0.0f;
        blue = 1.0f;
        gl.glClearColor(red, green, blue, 0.0f);
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 100, 0, 100, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//Remember point size refers
//to pixels, not the coordinate
//system we've set up in the
//GLCanvas
        gl.glPointSize(6.0f);
        red = 0.0f;
        green = 0.0f;
        blue = 0.0f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();
    }

    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size. We
     * won't need this, but you may eventually need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }
////////////////////////////////////////////
// MouseMotionListener implementation below

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
//get percent of GLCanvas instead of
//points and then converting it to our
//'100' based coordinate system.
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));
//reversing direction of y axis
        yPosition = 100 - yPosition;
        glc.repaint();
    }
}