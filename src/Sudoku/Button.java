package Sudoku;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private static final long serialVersionUID = 1L;
    Color Blue = Color.BLUE;
    Color White =  Color.WHITE;

    public Button(String action, String command) {
        super(action);
        this.setBackground(White);
        this.setForeground(Blue);
        this.setBorder(BorderFactory.createBevelBorder(0, Blue, Blue));
        this.setActionCommand(command);
    }

    public Dimension getPreferredSize() {
        return new Dimension(130, 30);
    }
}
