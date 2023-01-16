package HomeTask.Textures.Example1;
import HomeTask.Textures.AnimListener;
import HomeTask.Textures.TextureReader;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import javax.media.opengl.glu.GLU;

import static java.awt.event.KeyEvent.*;


public class AnimGLEventListener4 extends AnimListener implements Constants {

    Direction directions=Direction.UP;
    int angel ;

    boolean isFire;
//    HashMap<Point, Direction> map = new HashMap<>();
    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Direction> directions1 = new ArrayList<>();




    int animationIndex;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth / 2, y = maxHeight / 2;


    String[] textureNames = {"Man1.png", "Man2.png", "Man3.png", "Man4.png", "Back.png", "bullet.png"};
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int[] textures = new int[textureNames.length];


    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

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
                        texture[i].getPixels() // Image data
                );
            } catch (IOException e) {
//                    System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        DrawBackground(gl);
        handleKeyPress();
        animationIndex %= 4;

        DrawSprite(gl, x, y, animationIndex, 1);

//        map.forEach((point, dir1) -> {
//            switch (dir1) {
//                case UP -> DrawSprite(gl, point.x, point.y += 1, 5, 0.25f);
//                case DOWN -> DrawSprite(gl, point.x, point.y -= 1, 5, 0.25f);
//                case RIGHT -> DrawSprite(gl, point.x += 1, point.y, 5, 0.25f);
//                case LEFT -> DrawSprite(gl, point.x -= 1, point.y, 5, 0.25f);
//                case UP_RIGHT -> DrawSprite(gl, point.x += 1, point.y += 1, 5, 0.25f);
//                case UP_LEFT -> DrawSprite(gl, point.x -= 1, point.y += 1, 5, 0.25f);
//                case DOWN_RIGHT -> DrawSprite(gl, point.x += 1, point.y -= 1, 5, 0.25f);
//                case DOWN_LEFT -> DrawSprite(gl, point.x -= 1, point.y -= 1, 5, 0.25f);
//            }
//        });
        for (int i = 0; i < points.size(); i++) {
            switch (directions1.get(i)) {
                case UP -> DrawSprite(gl, points.get(i).x, points.get(i).y += 5, 5, 0.25f);
                case DOWN -> DrawSprite(gl, points.get(i).x, points.get(i).y -= 5, 5, 0.25f);
                case RIGHT -> DrawSprite(gl, points.get(i).x += 5, points.get(i).y, 5, 0.25f);
                case LEFT -> DrawSprite(gl, points.get(i).x -= 5, points.get(i).y, 5, 0.25f);
                case UP_RIGHT -> DrawSprite(gl, points.get(i).x += 5, points.get(i).y += 5, 5, 0.25f);
                case UP_LEFT -> DrawSprite(gl, points.get(i).x -= 5, points.get(i).y += 5, 5, 0.25f);
                case DOWN_RIGHT -> DrawSprite(gl, points.get(i).x += 5, points.get(i).y -= 5, 5, 0.25f);
                case DOWN_LEFT -> DrawSprite(gl, points.get(i).x -= 5, points.get(i).y -= 5, 5, 0.25f);
            }
        }

    }


    /**
     * keyListener
     */
    public void handleKeyPress() {



        //Directions
        if (isKeyPressed(VK_RIGHT) && isKeyPressed(VK_UP)) {
            angel = ANGEL_UP_RIGHT;
            directions = Direction.UP_RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT) && isKeyPressed(VK_UP)) {
            angel = ANGEL_UP_LEFT;
            directions = Direction.UP_LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT) && isKeyPressed(VK_DOWN)) {
            angel = ANGEL_DOWN_LEFT;
            directions = Direction.DOWN_LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_RIGHT) && isKeyPressed(VK_DOWN)) {
            angel = ANGEL_DOWN_RIGHT;
            directions = Direction.DOWN_RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_UP)) {
            angel = ANGEL_UP;
            directions = Direction.UP;
            animationIndex++;
        } else if (isKeyPressed(VK_RIGHT)) {
            angel = ANGEL_RIGHT;
            directions = Direction.RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT)) {
            angel = ANGEL_LEFT;
            directions = Direction.LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_DOWN)) {
            angel = ANGEL_DOWN;
            directions = Direction.DOWN;
            animationIndex++;
        }
        if (isKeyPressed(VK_LEFT))
            if (x > 0) x--;
        animationIndex++;

        if (isKeyPressed(VK_RIGHT))
            if (x < maxWidth - 10) x++;
        animationIndex++;

        if (isKeyPressed(VK_DOWN))
            if (y > 0) y--;
        animationIndex++;

        if (isKeyPressed(VK_UP))
            if (y < maxHeight - 10) y++;
        animationIndex++;

        //Fire
//        isFire = isKeyPressed(VK_SPACE);
//        if (isFire) {
//            map.put(new Point(x, y), directions);
//
//        }
        //Fire
        isFire = isKeyPressed(VK_SPACE);
        if (isFire) {
//            map.put(new Point(x, y), dir);
            points.add(new Point(x,y));
            directions1.add(directions);
        }


    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, int x, int y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);    // Turn Blending On


        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
        gl.glRotatef(angel, 0, 0, 1); //Dir
        //System.out.println(x +" " + y);
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

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);    // Turn Blending On

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


    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);

    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}