package view.FieldForGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Cell extends JPanel
{
    private static JLabel turtLabel = null;
    private static BufferedImage turtle = null;
    private static boolean draw = false;
    private boolean isColored;

    static
    {
        try
        {
            turtle= ImageIO.read(Cell.class.getResourceAsStream("/res/turtle-u.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Cell()
    {
    }

    public void load_turt()
    {
        turtLabel=new JLabel(new ImageIcon(turtle));
        add(turtLabel,BorderLayout.CENTER);
    }

    public void rem_turt()
    {
        turtLabel.setVisible(false);
        remove(turtLabel);
    }

    public boolean isTurtle()
    {
        if(getComponentCount()==1)
            return true;
        else
            return false;
    }

    public boolean isDraw()
    {

        return draw;
    }
    public void setDraw()
    {

        draw = !draw;
    }

    public boolean isColored() {

        return isColored;
    }

    public void setPainted(boolean colored) {

        isColored = colored;
    }
}
