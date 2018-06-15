package view;

import javax.swing.*;
import java.awt.*;

public class LogoWorld
{
    private static int height=430;
    private static int width=430;


    public static void start_game()
    {
        JFrame window=new MyWindow("LogoWorld");
        window.setSize(width,height);
        window.setBounds(400, 140, 430, 430);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }
}
