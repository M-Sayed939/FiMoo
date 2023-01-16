package CardGame;

import HomeTask.Textures.AnimListener;
import HomeTask.Textures.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;


public class ChangeCard extends
            AnimListener implements GLEventListener, MouseMotionListener  {
        String textureNames[] = {"Backcard.png","j.png", "GreenBack.jpg"};
        TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
        int textures[] = new int[textureNames.length];

        int xPosition = 50;
        int yPosition = 50;
        float red = 0.0f;
        float green = 0.0f;
        float blue = 0.0f;
        GLCanvas glc;
    double max_X = 1, max_Y = 1, min_X = -1, min_Y = -1;
    double x = 0, y = 0;
    double quad_radius = 1;
    double scale = 0.1;

        public void setGLCanvas(GLCanvas glc) {
            this.glc = glc;
        }

        /**
         * Take care of initialization here.
         */
        public void init(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            gl.glClearColor(red, green, blue, 1.0f);
            gl.glViewport(0, 0, 100, 100);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrtho(0.0, 100, 0, 100, -1, 1);
            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            texture[i].getPixels() // Imagedata
                    );
                } catch (IOException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
             }

        /**
         * Take care of drawing here.
         */
        int i=0;
        int[][] arr =new int[1000][2];
        public void display(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glLoadIdentity();

            DrawBackground(gl);
            DrawSprite(gl, x, y, 0, scale);
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
            for(int j=0;j<=i;j++){
                gl.glVertex2i(arr[j][0], arr[j][1]);
            }
            gl.glEnd();
            gl.glColor3f(1.0f, green, blue);
            gl.glBegin(GL.GL_LINES);
            if(i%2==1){
                for(int j=0;j<=i-1;j++){
                    gl.glVertex2i(arr[j][0], arr[j][1]);
                }
            }
            else {
                for(int j=0;j<=i;j++){
                    gl.glVertex2i(arr[j][0], arr[j][1]);
                }
            }
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
    public void DrawSprite(GL gl, double x, double y, int index, double scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
        //gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);

        gl.glTranslated(x * scale, y * scale, 1);
        gl.glScaled(scale, scale, 1);

        //
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);
        //gl.glColor3f(0, 0, 0);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
        //gl.glColor3f(1, 1, 1);
    }
    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }
////////////////////////////////////////////
// MouseListener implementation below




        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    public static void main(String[] args) {
        new Test(new CardGame.ChangeCard());
    }

}
