package Sudoku;

import java.awt.*;

public class SPanel extends Panel
{
    private static final long serialVersionUID = 1L;
    Color WS = new Color(0xf5, 0xf5, 0xf5);
    public SPanel(Dimension set) 
    {
       super();
       this.setBackground(WS);
       this.setPreferredSize(set);
    }
}

